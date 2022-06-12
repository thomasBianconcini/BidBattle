import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.CBanner;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;

public class Modificadati {

	protected Shell shell;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text;
	private Text text_1;
	private Text text_5;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Modificadati window = new Modificadati();
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
		shell.setSize(685, 650);
		shell.setLayout(null);
		
		Label lblRegistrazione = new Label(shell, SWT.NONE);
		lblRegistrazione.setBounds(274, 23, 117, 28);
		lblRegistrazione.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblRegistrazione.setForeground(SWTResourceManager.getColor(0, 0, 0));
		lblRegistrazione.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblRegistrazione.setText("ModificaDati");
		
		Label lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setBounds(120, 55, 180, 15);
		lblEmail.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblEmail.setText("Email: Marco1234@gmail.com");
		
		Label lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setBounds(120, 115, 153, 15);
		lblPassword.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblPassword.setText("Password: **********");
		
		Label lblminimoCaratteri = new Label(shell, SWT.NONE);
		lblminimoCaratteri.setBounds(120, 173, 180, 11);
		lblminimoCaratteri.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblminimoCaratteri.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		lblminimoCaratteri.setText("(Minimo 8 caratteri, almeno una lettera maiuscola)");
		
		Label lblConfermaPassword = new Label(shell, SWT.NONE);
		lblConfermaPassword.setBounds(120, 190, 109, 15);
		lblConfermaPassword.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblConfermaPassword.setText("Conferma Password:");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(120, 220, 439, 21);
		
		Label lblIndirizzo = new Label(shell, SWT.NONE);
		lblIndirizzo.setBounds(120, 250, 195, 15);
		lblIndirizzo.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblIndirizzo.setText("Indirizzo: (via Lazio 3 Modena )");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(120, 280, 439, 21);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(120, 145, 439, 21);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(120, 85, 439, 21);
		
		Label lblNomeprofilo = new Label(shell, SWT.NONE);
		lblNomeprofilo.setBounds(120, 310, 180, 15);
		lblNomeprofilo.setText("NomeProfilo: marco1234");
		lblNomeprofilo.setBackground(SWTResourceManager.getColor(255, 215, 0));
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(120, 340, 439, 21);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(512, 116, 47, 15);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		btnNewButton.setText("Show");
		
		Label lblImmagine = new Label(shell, SWT.NONE);
		lblImmagine.setBounds(120, 370, 180, 15);
		lblImmagine.setText("Descrizione : 18 anni , pallavolo ");
		lblImmagine.setBackground(SWTResourceManager.getColor(255, 215, 0));
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(120, 400, 439, 21);
		
		Label lblImmagine_1 = new Label(shell, SWT.NONE);
		lblImmagine_1.setBounds(120, 430, 180, 15);
		lblImmagine_1.setText("Immagine:");
		lblImmagine_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		
		Group group = new Group(shell, SWT.NONE);
		group.setBounds(120, 451, 109, 109);
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(484, 535, 75, 25);
		btnNewButton_1.setText("Modifica");
		
		
	}
}

