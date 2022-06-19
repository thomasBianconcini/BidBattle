import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import controller.GestioneWalletController;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Prelievo {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_4;
private Shell walletShell;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Prelievo window = new Prelievo();
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
		shell.setSize(312, 472);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Label lblOfferta = new Label(shell, SWT.NONE);
		lblOfferta.setBounds(34, 28, 96, 28);
		lblOfferta.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblOfferta.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblOfferta.setText("Prelievo");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(34, 84, 117, 15);
		lblNewLabel.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel.setText("Nome Intestatario:");
		
		Label lblImporto = new Label(shell, SWT.NONE);
		lblImporto.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblImporto.setBounds(34, 144, 43, 15);
		lblImporto.setText("IBAN:");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(34, 174, 216, 21);
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setItems(new String[] {"Euro", "Dollaro", "Pound"});
		combo.setBounds(148, 232, 68, 23);
		
		Button btnOffri = new Button(shell, SWT.NONE);
		btnOffri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				
			}
		});
		btnOffri.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!text_1.getText().isEmpty() && !text.getText().isEmpty())
				{
					GestioneWalletController gc = new  GestioneWalletController();
					gc.prelievo(Double.parseDouble(text_4.getText()), combo.getText());
					Wallet w = new Wallet();
					shell.close();
					w.open();
				}
			
			}
		});
		btnOffri.setBounds(34, 274, 49, 25);
		btnOffri.setText("Ricarica");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(34, 117, 216, 21);
		
		Label lblImport = new Label(shell, SWT.NONE);
		lblImport.setText("Importo:");
		lblImport.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblImport.setBounds(34, 204, 68, 15);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(34, 234, 49, 21);
		
		Label lblValuta = new Label(shell, SWT.NONE);
		lblValuta.setText("Valuta:");
		lblValuta.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblValuta.setBounds(163, 204, 68, 15);
		
		
	}

	public Shell getWalletShell() {
		return walletShell;
	}

	public void setWalletShell(Shell walletShell) {
		this.walletShell = walletShell;
	}

}


