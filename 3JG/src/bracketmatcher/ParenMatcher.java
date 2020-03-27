package bracketmatcher;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.BorderLayout;
 
public class ParenMatcher extends JTextPane implements Runnable 
{
 
  public static Color[] matchColor = { Color.BLUE, Color.MAGENTA, 
		  Color.GREEN, Color.ORANGE};
  public static Color badColor = Color.RED;
 
  private AttributeSet[] matchAttrSet;
  private AttributeSet badAttrSet;
  private Thread t;
 
  public ParenMatcher() {
    // create an array of AttributeSets from the array of Colors
    StyleContext sc = StyleContext.getDefaultStyleContext();
    badAttrSet = sc.addAttribute(SimpleAttributeSet.EMPTY,
                          StyleConstants.Foreground, badColor);
    matchAttrSet = new AttributeSet[matchColor.length];
    for (int j=0; j < matchColor.length; j+=1)
      matchAttrSet[j] = sc.addAttribute(SimpleAttributeSet.EMPTY,
                                 StyleConstants.Foreground, matchColor[j]);

  }
   
  // match and color the parens/brackets/braces
  public void run() {
    StyledDocument doc = getStyledDocument();
    String text = "";
    int len = doc.getLength();
    try {
      text = doc.getText(0, len);
    } catch (BadLocationException ble) { }
    java.util.Stack<CharPosition> stack = new java.util.Stack<CharPosition>();
    for (int j=0; j < text.length(); j+=1) {
      char ch = text.charAt(j);
      if (ch == '(' || ch == '[' || ch == '{') {
        int depth = stack.size();
        stack.push(new CharPosition(ch,j)); // push a String containg the char and the offset
        AttributeSet aset = matchAttrSet[depth % matchAttrSet.length];
        doc.setCharacterAttributes(j, 1, aset, false);
      }
      if (ch == ')' || ch == ']' || ch == '}') {
        char peek = stack.empty() ? '.' : stack.peek().getC();
        if (matches(peek, ch)) { // does it match?
          stack.pop();
          int depth = stack.size();
          AttributeSet aset = matchAttrSet[depth % matchAttrSet.length];
          doc.setCharacterAttributes(j, 1, aset, false);
        }
        else { // mismatch
          doc.setCharacterAttributes(j, 1, badAttrSet, false);
        }
      }
     }
      
     while (! stack.empty()) { // anything left in the stack is a mismatch
       CharPosition pop = stack.pop();
       int offset = pop.getPos();
       doc.setCharacterAttributes(offset, 1, badAttrSet, false);
     }
  }
 
  // unset the foreground color (if any) whenever the user enters text
  // (if not for this, text entered after a paren would catch the paren's color)
  public void replaceSelection(String content) {
    getInputAttributes().removeAttribute(StyleConstants.Foreground);
    super.replaceSelection(content);
  }
 
  // return true if 'left' and 'right' are matching parens/brackets/braces
  public static boolean matches(char left, char right) {
    if (left == '(') return (right == ')');
    if (left == '[') return (right == ']');
    if (left == '{') return (right == '}');
    return false;
  }
 
  public static void main(String[] args) {
    JFrame frame = new JFrame("ParenMatcher");
 
    final ParenMatcher matcher = new ParenMatcher();
    matcher.setText("int fact(int n) {\n"
                   +"  if (n <= 1) return 1;\n"
                   +"  return(n * fact(n-1));\n"
                   +"}\n");
    frame.getContentPane().add(new JScrollPane(matcher), BorderLayout.CENTER);
 
    JButton matchButton = new JButton("match parens");
    matchButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) { matcher.run(); }
    });
    frame.getContentPane().add(matchButton, BorderLayout.SOUTH);
 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 150);
    frame.setVisible(true);
  }
}