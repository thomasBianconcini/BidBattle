import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class EliminaAsta {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			EliminaAsta window = new EliminaAsta();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(255, 215, 0));
		shell.setSize(273, 359);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Label lblOfferta = new Label(shell, SWT.NONE);
		lblOfferta.setBounds(34, 28, 150, 28);
		lblOfferta.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblOfferta.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblOfferta.setText("Elimina Asta");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(34, 84, 96, 15);
		lblNewLabel.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel.setText("id asta:");
		
		Button btnOffri = new Button(shell, SWT.NONE);
		btnOffri.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnOffri.setBounds(34, 236, 77, 25);
		btnOffri.setText("Elimina");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(34, 174, 168, 44);
		
		Label lblMotivazione = new Label(shell, SWT.NONE);
		lblMotivazione.setText("Motivazione:");
		lblMotivazione.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblMotivazione.setBounds(34, 144, 96, 15);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(34, 114, 168, 21);

	}

}


