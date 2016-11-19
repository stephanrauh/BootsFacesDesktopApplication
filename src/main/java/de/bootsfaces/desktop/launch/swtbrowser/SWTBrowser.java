package de.bootsfaces.desktop.launch.swtbrowser;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public final class SWTBrowser {

	public static final void launch() {
		Display display = new Display();
		final Shell shell = new Shell(display);
		Rectangle clientArea = display.getClientArea();
		shell.setSize(clientArea.width, clientArea.height);
		shell.setLocation(0, 0);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		// shell.setFullScreen(true);

		shell.setLayout(gridLayout);

		final Browser browser = new Browser(shell, SWT.NONE);
		GridData data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.FILL;
		data.horizontalSpan = 3;
		data.grabExcessHorizontalSpace = true;
		data.grabExcessVerticalSpace = true;
		data.widthHint = clientArea.width;
		data.heightHint = clientArea.height;
		browser.setLayoutData(data);

		shell.open();
		browser.setUrl("http://localhost:8080");

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}