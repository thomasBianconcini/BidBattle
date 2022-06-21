import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;

import controller.RegistrazioneController;
import model.DbMock;
import model.Utente;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.CBanner;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Registrazione  {

	private Display display = Display.getDefault();
	private static Registrazione window = new Registrazione();
	protected Shell shell;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text;
	private Shell shellNon;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			try {
				window.open();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
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
		shell.setSize(729, 469);
		shell.setText("Registrazione");
		shell.setLayout(null);
		
		Label lblRegistrazione = new Label(shell, SWT.NONE);
		lblRegistrazione.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblRegistrazione.setBounds(253, 23, 162, 37);
		lblRegistrazione.setForeground(SWTResourceManager.getColor(255, 127, 80));
		lblRegistrazione.setFont(SWTResourceManager.getFont("Segoe UI", 17, SWT.BOLD));
		lblRegistrazione.setText("Registrazione");
		
		Label lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblEmail.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblEmail.setBounds(120, 60, 32, 15);
		lblEmail.setText("Email:");
		
		Label lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblPassword.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblPassword.setBounds(120, 120, 153, 15);
		lblPassword.setText("Password:");
		
		Label lblminimoCaratteri = new Label(shell, SWT.NONE);
		lblminimoCaratteri.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblminimoCaratteri.setBounds(120, 175, 180, 11);
		lblminimoCaratteri.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		lblminimoCaratteri.setText("(Minimo 8 caratteri, almeno una lettera maiuscola)");
		
		Label lblConfermaPassword = new Label(shell, SWT.NONE);
		lblConfermaPassword.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblConfermaPassword.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblConfermaPassword.setBounds(120, 190, 153, 15);
		lblConfermaPassword.setText("Conferma Password:");
		
		text_2 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_2.setBounds(120, 220, 439, 21);
		
		Label lblIndirizzo = new Label(shell, SWT.NONE);
		lblIndirizzo.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblIndirizzo.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblIndirizzo.setBounds(120, 250, 93, 15);
		lblIndirizzo.setText("Indirizzo:");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(120, 280, 439, 21);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel.setBounds(199, 315, 383, 37);
		
		Button btnRegistrati = new Button(shell, SWT.NONE);
		btnRegistrati.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				RegistrazioneController rc = new RegistrazioneController();
				String check =rc.Registrazione(text.getText(), text_4.getText(), text_2.getText(), text_3.getText());
				if(check.equals("OK"))
				{
				Home home= new Home();
				shellNon.close();
				shell.close();
				home.open();
				}else
				{
					lblNewLabel.setText(check);
				}
			}
		});
		btnRegistrati.setGrayed(true);
		btnRegistrati.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnRegistrati.setBounds(120, 310, 61, 25);
		btnRegistrati.setForeground(SWTResourceManager.getColor(255, 0, 0));
		btnRegistrati.setText("Registrati");
		
		text_4 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_4.setBounds(120, 150, 439, 21);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(120, 90, 439, 21);
	}

	public Shell getShellNon() {
		return shellNon;
	}

	public void setShellNon(Shell shellNon) {
		this.shellNon = shellNon;
	}
	
}
