import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class GestioneSistema {

	protected Shell shell;
	private Display display = Display.getDefault();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GestioneSistema window = new GestioneSistema();
			window.open();
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
		shell.setSize(668, 340);
		shell.setText("SWT Application");
		shell.setBackground(SWTResourceManager.getColor(255, 215, 0));
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label.setBounds(135, -19, 2, 307);
		
		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label_1.setBounds(-11, 135, 148, 2);
		
		Label label_1_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label_1_1.setBounds(-11, 185, 148, 2);
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label_2.setBounds(-11, 235, 148, 2);
		
		Label label_1_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label_1_2.setBounds(-11, 285, 148, 10);
		
		Label label_1_4 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1_4.setBounds(-11, 385, 148, 2);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				EliminaUtente eliminaUtente= new EliminaUtente();
				eliminaUtente.open();
			}
		});
		lblNewLabel.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel.setBounds(32, 153, 78, 15);
		lblNewLabel.setText("Elimina Utente");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				EliminaAsta eliminaAsta= new EliminaAsta();
			eliminaAsta.open();
			}
		});
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_1.setText("Elimina Asta");
		lblNewLabel_1.setBounds(32, 203, 78, 15);
		
		Label lblNewLabel_1_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				AnalisiDati analisiDati= new AnalisiDati();
							analisiDati.open();
			}
		});
		lblNewLabel_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_1_1.setText("Statistiche");
		lblNewLabel_1_1.setBounds(32, 253, 78, 15);
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setBounds(0, 0, 134, 134);
		lblNewLabel_4.setImage(new Image(display,"logo.png"));
		
		Group grpLeMieAste = new Group(shell, SWT.BORDER);
		grpLeMieAste.setBackground(SWTResourceManager.getColor(255, 215, 0));
		grpLeMieAste.setBounds(172, 50, 429, 365);
		
		Label lblAsta = new Label(grpLeMieAste, SWT.NONE);
		lblAsta.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblAsta.setBounds(10, 41, 67, 15);
		lblAsta.setText("Azione1");
		
		Label lblTitoloAsta = new Label(grpLeMieAste, SWT.NONE);
		lblTitoloAsta.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTitoloAsta.setBounds(10, 66, 260, 15);
		lblTitoloAsta.setText("Elimina Utente  email : fabio12345@gmail.com");
		
		Button btnNewButton = new Button(grpLeMieAste, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		btnNewButton.setBounds(352, 67, 55, 15);
		btnNewButton.setText("Visualizza");
		
		Label lblAsta_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblAsta_1_1.setText("Azione2");
		lblAsta_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblAsta_1_1.setBounds(10, 116, 67, 15);
		
		Label lblTitoloAsta_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblTitoloAsta_1_1.setText("Elimina Asta id= 12343");
		lblTitoloAsta_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTitoloAsta_1_1.setBounds(10, 141, 223, 15);
		
		Label lblAsta_1_1_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblAsta_1_1_1_1.setText("Azione3");
		lblAsta_1_1_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblAsta_1_1_1_1.setBounds(10, 191, 67, 15);
		
		Label lblTitoloAsta_1_1_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblTitoloAsta_1_1_1_1.setText("Elimina Utente  email : luca2345@gmail.com");
		lblTitoloAsta_1_1_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTitoloAsta_1_1_1_1.setBounds(10, 216, 223, 15);
		
		Button btnNewButton_2 = new Button(grpLeMieAste, SWT.NONE);
		btnNewButton_2.setText("Visualizza");
		btnNewButton_2.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		btnNewButton_2.setBounds(352, 142, 55, 15);
	
		
		Button btnNewButton_4 = new Button(grpLeMieAste, SWT.NONE);
		btnNewButton_4.setText("Visualizza");
		btnNewButton_4.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		btnNewButton_4.setBounds(352, 217, 55, 15);
		
		Label lblGestioneSistema = new Label(shell, SWT.NONE);
		lblGestioneSistema.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblGestioneSistema.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblGestioneSistema.setBounds(301, 10, 181, 34);
		lblGestioneSistema.setText("Gestione Sistema");
	}
}
