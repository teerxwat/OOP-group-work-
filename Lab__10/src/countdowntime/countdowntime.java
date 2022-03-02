package countdowntime;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

public class countdowntime {

	protected Shell shlCountdownTimer;
	private Text Hr;
	private Text Mi;
	private Text Se;
	private Label Hr_lb_1;
	private Label Hr_lb_2;
	private Label Hr_lb_3;
	private Label Hr_lb_4;
	private Label CD_s;
	private Label Hr_lb_5;
	private Label CD_m;
	private Label CD_h;
	private Label Hr_lb_6;
	private Label Hr_lb_7;
	private Label Hr_lb_8;
	private Label Hr_lb_9;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			countdowntime window = new countdowntime();
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
		shlCountdownTimer.open();
		shlCountdownTimer.layout();
		while (!shlCountdownTimer.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCountdownTimer = new Shell();
		shlCountdownTimer.setSize(741, 498);
		shlCountdownTimer.setText("countdown timer");
		
		Hr_lb_8 = new Label(shlCountdownTimer, SWT.NONE);
		Hr_lb_8.setText("Countdown");
		Hr_lb_8.setForeground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		Hr_lb_8.setFont(SWTResourceManager.getFont("TH SarabunPSK", 50, SWT.BOLD));
		Hr_lb_8.setBounds(387, -17, 326, 101);
		
		Hr = new Text(shlCountdownTimer, SWT.BORDER | SWT.CENTER);
		Hr.setText("00");
		Hr.setFont(SWTResourceManager.getFont("TH SarabunPSK", 20, SWT.BOLD));
		Hr.setBounds(30, 81, 83, 62);
		
		Mi = new Text(shlCountdownTimer, SWT.BORDER | SWT.CENTER);
		Mi.setText("00");
		Mi.setFont(SWTResourceManager.getFont("TH SarabunPSK", 20, SWT.BOLD));
		Mi.setBounds(140, 81, 83, 62);
		
		
		
		Se = new Text(shlCountdownTimer, SWT.BORDER | SWT.CENTER);
		Se.setText("00");
		Se.setFont(SWTResourceManager.getFont("TH SarabunPSK", 20, SWT.BOLD));
		Se.setBounds(250, 81, 83, 62);
		
		/////////////////////////////////////////////////////////////////////////////////// button
		
		Button Submit = new Button(shlCountdownTimer, SWT.NONE);
		Submit.setFont(SWTResourceManager.getFont("TH SarabunPSK", 20, SWT.BOLD));
		Submit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String sec = Se.getText();
				String min = Mi.getText();
				String hou = Hr.getText();
				
				int secnum =  Integer.parseInt(sec);
				int minnum =  Integer.parseInt(min);
				int hounum =  Integer.parseInt(hou);
				
				
				CD_h.setText(Integer.toString(hounum));
				CD_m.setText(Integer.toString(minnum));
				CD_s.setText(Integer.toString(secnum));
				
				
				if(secnum > 60 || minnum > 60 || hounum > 24) //check time
					{ System.out.println("ERROR");  
					
					} else {
						
						do {
							  
							  if(secnum != 0) {
								  for (int i = secnum; i > 0; i--) {
									   try {
										Thread.sleep(1000);
									} catch (InterruptedException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									   System.out.print(i + " ");
									   CD_s.setText(Integer.toString(i));
									  }
								  secnum = 0;
							  }
							  
							  for(int j = minnum; j > 0 ; j--) {
								  if(secnum == 0) {
									  minnum = minnum - 1;
									  secnum = secnum + 60;
									  CD_m.setText(Integer.toString(minnum));
									  CD_s.setText(Integer.toString(secnum));
									  for (int i = secnum; i > 0; i--) {
										   try {
											Thread.sleep(1000);
										} catch (InterruptedException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										   System.out.print(i + " ");
										   CD_s.setText(Integer.toString(i));
										  }
										  secnum = 0;
									}
							  }
								  
							  for(int k = hounum; k > 0 ; k--) {
								  if(minnum == 0 && secnum == 0) {
									  hounum = hounum - 1;
									  minnum = minnum + 60;
									  CD_h.setText(Integer.toString(hounum));
									  CD_m.setText(Integer.toString(minnum));
									  CD_s.setText(Integer.toString(secnum));
									  for(int j = minnum; j > 0 ; j--) {
										  if(secnum == 0) {
											  minnum = minnum - 1;
											  secnum = secnum + 60;
											  CD_m.setText(Integer.toString(minnum));
											  CD_s.setText(Integer.toString(secnum));
											  for (int i = secnum; i > 0; i--) {
												   try {
													Thread.sleep(1000);
												} catch (InterruptedException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												   System.out.print(i + " ");
												   CD_s.setText(Integer.toString(i));
												 }
												  secnum = 0;
											}
									  }
								  }
							  }
								  
						  }while(hounum !=0 && minnum != 0 && secnum != 0);
						
					}
			}
		});
		Submit.setBounds(140, 372, 445, 69);
		Submit.setText("Submit Stop Setting");
		
		/////////////////////////////////////////////////////////////////////////////////// end button
		
		Label Hr_lb = new Label(shlCountdownTimer, SWT.CENTER);
		Hr_lb.setFont(SWTResourceManager.getFont("TH SarabunPSK", 20, SWT.BOLD));
		Hr_lb.setBounds(30, 41, 83, 34);
		Hr_lb.setText("Hour");
		
		Hr_lb_1 = new Label(shlCountdownTimer, SWT.CENTER);
		Hr_lb_1.setText("Minute");
		Hr_lb_1.setFont(SWTResourceManager.getFont("TH SarabunPSK", 20, SWT.BOLD));
		Hr_lb_1.setBounds(140, 41, 83, 34);
		
		Hr_lb_2 = new Label(shlCountdownTimer, SWT.CENTER);
		Hr_lb_2.setText("Second");
		Hr_lb_2.setFont(SWTResourceManager.getFont("TH SarabunPSK", 20, SWT.BOLD));
		Hr_lb_2.setBounds(250, 41, 83, 34);
		
		Hr_lb_3 = new Label(shlCountdownTimer, SWT.NONE);
		Hr_lb_3.setText(":");
		Hr_lb_3.setFont(SWTResourceManager.getFont("TH SarabunPSK", 20, SWT.BOLD));
		Hr_lb_3.setBounds(119, 70, 15, 59);
		
		Hr_lb_4 = new Label(shlCountdownTimer, SWT.NONE);
		Hr_lb_4.setText(":");
		Hr_lb_4.setFont(SWTResourceManager.getFont("TH SarabunPSK", 20, SWT.BOLD));
		Hr_lb_4.setBounds(229, 70, 15, 59);
		
		CD_s = new Label(shlCountdownTimer, SWT.NONE);
		CD_s.setAlignment(SWT.CENTER);
		CD_s.setText("00");
		CD_s.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		CD_s.setFont(SWTResourceManager.getFont("TH SarabunPSK", 75, SWT.BOLD));
		CD_s.setBounds(489, 174, 152, 181);
		
		Hr_lb_5 = new Label(shlCountdownTimer, SWT.NONE);
		Hr_lb_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		Hr_lb_5.setText("Enter Time");
		Hr_lb_5.setFont(SWTResourceManager.getFont("TH SarabunPSK", 20, SWT.BOLD));
		Hr_lb_5.setBounds(10, 10, 214, 34);
		
		Label label = new Label(shlCountdownTimer, SWT.NONE);
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		label.setBounds(0, 157, 364, 11);
		
		Label label_1 = new Label(shlCountdownTimer, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		label_1.setBounds(353, 0, 11, 158);
		
		CD_m = new Label(shlCountdownTimer, SWT.NONE);
		CD_m.setAlignment(SWT.CENTER);
		CD_m.setText("00");
		CD_m.setFont(SWTResourceManager.getFont("TH SarabunPSK", 75, SWT.BOLD));
		CD_m.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		CD_m.setBounds(293, 174, 152, 187);
		
		CD_h = new Label(shlCountdownTimer, SWT.NONE);
		CD_h.setAlignment(SWT.CENTER);
		CD_h.setText("00");
		CD_h.setFont(SWTResourceManager.getFont("TH SarabunPSK", 75, SWT.BOLD));
		CD_h.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		CD_h.setBounds(94, 174, 150, 193);
		
		Hr_lb_6 = new Label(shlCountdownTimer, SWT.NONE);
		Hr_lb_6.setText(":");
		Hr_lb_6.setFont(SWTResourceManager.getFont("TH SarabunPSK", 75, SWT.BOLD));
		Hr_lb_6.setBounds(252, 174, 36, 144);
		
		Hr_lb_9 = new Label(shlCountdownTimer, SWT.CENTER);
		Hr_lb_9.setText("Time");
		Hr_lb_9.setForeground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		Hr_lb_9.setFont(SWTResourceManager.getFont("TH SarabunPSK", 50, SWT.BOLD));
		Hr_lb_9.setBounds(370, 59, 349, 84);
		
		Hr_lb_7 = new Label(shlCountdownTimer, SWT.NONE);
		Hr_lb_7.setText(":");
		Hr_lb_7.setFont(SWTResourceManager.getFont("TH SarabunPSK", 75, SWT.BOLD));
		Hr_lb_7.setBounds(451, 174, 36, 144);

	}
}
