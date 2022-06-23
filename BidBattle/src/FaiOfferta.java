import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import controller.InterazioneAstaController;
import model.Asta;
import model.DbMock;
import model.Offerta;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class FaiOfferta {

	protected Shell shell;
	private Text text;
	private String nomeAsta;
	DbMock db = new DbMock();
	Shell p;
	private Boolean va;
	Shell chiSono;
	private boolean inHome = true;
	public String getNomeAsta() {
		return nomeAsta;
	}

	public void setNomeAsta(String nomeAsta) {
		this.nomeAsta = nomeAsta;
	}

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
		lblOfferta.setBounds(34, 52, 96, 28);
		lblOfferta.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblOfferta.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblOfferta.setText("Offerta");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(34, 106, 87, 15);
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_2.setText("Offerta corrente:");
		
		Asta a= DbMock.getAstabyTitolo(nomeAsta);
		Label label = new Label(shell, SWT.NONE);
		label.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label.setBounds(166, 106, 33, 15);
		if(a.getCurrent()==-1)
		{
			label.setText(""+a.getPrezzoIniziale());
		}else
		label.setText(""+a.getCurrent());
		
		Label lblImporto = new Label(shell, SWT.NONE);
		lblImporto.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblImporto.setBounds(34, 144, 43, 15);
		lblImporto.setText("Importo");
		
		text = new Text(shell, SWT.BORDER);
		text.setBackground(SWTResourceManager.getColor(255, 215, 0));
		text.setBounds(113, 141, 86, 21);
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label_1.setBounds(86, 184, 138, 15);
		Button btnOffri = new Button(shell, SWT.NONE);
		btnOffri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				InterazioneAstaController ic= new InterazioneAstaController();
				Offerta o=ic.inserisciOfferta(a,Double.parseDouble(text.getText()), DbMock.getCurrentUser().getEmail());
				if(o==null)
				{
					label_1.setText("Importo troppo basso");
				}else
				{
					if(inHome)
					{
					Home h = new Home();
					va=false;
					
					p.close();
					chiSono.close();
					shell.close();
					h.open();
					}else
					{
						InterazioneAste ia = new InterazioneAste();
						p.close();
						chiSono.close();
						shell.close();
						ia.open();
					}
				}
			}
		});
		//DbMock.getCurrentUser().getEmail()
		btnOffri.setBounds(34, 184, 36, 25);
		btnOffri.setText("Offri");
		

	}

	public Shell getP() {
		return p;
	}

	public void setP(Shell p) {
		this.p = p;
	}

	public boolean isInHome() {
		return inHome;
	}

	public void setInHome(boolean inHome) {
		this.inHome = inHome;
	}

	public Boolean getVa() {
		return va;
	}

	public void setVa(Boolean va) {
		this.va = va;
	}

	public Shell getChiSono() {
		return chiSono;
	}

	public void setChiSono(Shell chiSono) {
		this.chiSono = chiSono;
	}
	
}
