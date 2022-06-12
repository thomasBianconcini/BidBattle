import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Login {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Login window = new Login();
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
		shell.setSize(994, 729);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Label lblLogin = new Label(shell, SWT.NONE);
		lblLogin.setBounds(339, 109, 117, 28);
		lblLogin.setText("Login");
		lblLogin.setForeground(SWTResourceManager.getColor(255, 127, 80));
		lblLogin.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblLogin.setBackground(SWTResourceManager.getColor(255, 215, 0));
		
		Label lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setBounds(185, 150, 32, 15);
		lblEmail.setText("Email:");
		lblEmail.setBackground(SWTResourceManager.getColor(255, 215, 0));
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(185, 180, 439, 21);
		
		Label lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setBounds(185, 210, 53, 15);
		lblPassword.setText("Password:");
		lblPassword.setBackground(SWTResourceManager.getColor(255, 215, 0));
		
		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(185, 240, 439, 21);
		
		Button btnLogin = new Button(shell, SWT.NONE);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				System.out.println("ciao "+ text.getText()+ "passwd " +text_1.getText() );
			}
		});
		btnLogin.setBounds(185, 280, 75, 25);
		btnLogin.setForeground(SWTResourceManager.getColor(255, 69, 0));
		btnLogin.setText("Login");

	}
}
