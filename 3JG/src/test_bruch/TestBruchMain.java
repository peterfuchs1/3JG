package test_bruch;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import org.junit.platform.launcher.*;
import org.junit.platform.launcher.core.*;
import org.junit.platform.launcher.listeners.*;

public class TestBruchMain{

	public static void main(String[] args) {
		LauncherDiscoveryRequest request = 
				LauncherDiscoveryRequestBuilder.request()
				.selectors(selectClass(Test5Bruch.class))
				.build();
				
				Launcher launcher = LauncherFactory.create();
				// Register a listener of your choice
				SummaryGeneratingListener listener = new SummaryGeneratingListener();
				launcher.registerTestExecutionListeners(listener);
				launcher.execute(request);
				TestExecutionSummary summary = listener.getSummary();
				// Do something with the TestExecutionSummary.
				System.out.println("Tests found: "+summary.getTestsFoundCount());
				System.out.println("Tests succeeded: "+summary.getTestsSucceededCount());
				System.out.println("Tests failed: "+summary.getTestsFailedCount());
	}

}
