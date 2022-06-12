import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;

public class FaiOfferta {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FaiOfferta window = new FaiOfferta();
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
		shell.setSize(273, 294);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Label lblOfferta = new Label(shell, SWT.NONE);
		lblOfferta.setBounds(34, 28, 96, 28);
		lblOfferta.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblOfferta.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblOfferta.setText("Offerta");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(34, 84, 96, 15);
		lblNewLabel.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel.setText("Tempo rimanente:");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_1.setBounds(157, 84, 42, 15);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(0, 0, 0));
		lblNewLabel_1.setText("12:15:54");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(34, 114, 87, 15);
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_2.setText("Offerta corrente:");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label.setBounds(166, 114, 33, 15);
		label.setText("150,00");
		
		Label lblImporto = new Label(shell, SWT.NONE);
		lblImporto.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblImporto.setBounds(34, 144, 43, 15);
		lblImporto.setText("Importo");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(113, 141, 86, 21);
		
		Button btnOffri = new Button(shell, SWT.NONE);
		btnOffri.setBounds(34, 184, 36, 25);
		btnOffri.setText("Offri");

	}

}
