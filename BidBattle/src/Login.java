import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import controller.LoginController;
import model.DbMock;
import model.Utente;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Login {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Shell shellNon;
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
		shell.setSize(673, 423);
		shell.setText("Login");
		shell.setLayout(null);
		
		Label lblLogin = new Label(shell, SWT.NONE);
		lblLogin.setBounds(262, 61, 117, 87);
		lblLogin.setText("Login");
		lblLogin.setForeground(SWTResourceManager.getColor(255, 127, 80));
		lblLogin.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		lblLogin.setBackground(SWTResourceManager.getColor(255, 215, 0));
		
		Label lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblEmail.setBounds(100, 133, 32, 15);
		lblEmail.setText("Email:");
		lblEmail.setBackground(SWTResourceManager.getColor(255, 215, 0));
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(100, 163, 439, 21);
		
		Label lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblPassword.setBounds(100, 193, 53, 15);
		lblPassword.setText("Password:");
		lblPassword.setBackground(SWTResourceManager.getColor(255, 215, 0));
		
		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(100, 223, 439, 21);
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel.setBounds(218, 268, 306, 21);
		Button btnLogin = new Button(shell, SWT.NONE);
		btnLogin.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				LoginController lc = new LoginController();
				boolean check= lc.verificaAccesso( text.getText(), text_1.getText());
				if(check)
				{
					Home h= new Home();
					shellNon.close();
					shell.close();
					h.open();
				}else
				{
					lblNewLabel.setText("Riprova credenziali errate");
				}
			}
		});
		btnLogin.setBounds(100, 263, 75, 25);
		btnLogin.setForeground(SWTResourceManager.getColor(255, 69, 0));
		btnLogin.setText("Login");
		
	}

	public Shell getShellNon() {
		return shellNon;
	}

	public void setShellNon(Shell shellNon) {
		this.shellNon = shellNon;
	}
	
}
