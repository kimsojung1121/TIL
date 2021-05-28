package xyz.itwill.io;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

//텍스트 파일 편집기 프로그램 - 메모장
public class NotepadApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
//필드	
	private JMenuItem init, open, save, exit;
	private JTextArea area;
	private FileDialog openDialog, saveDialog;
	
	//현재 편집중인 파일의 경로를 저장하기 위한 필드
	private String filePath;
	
	//JTextArea 컴퍼넌트의 내용 변경 상태를 저장하기 위한 필드
	// => false : 미변경, true : 변경
	private boolean state;

//생성자	
	public NotepadApp(String title) {
		super(title);
		
		//메뉴 만들기
		JMenuBar bar=new JMenuBar();
		JMenu menu=new JMenu("파일(F)");
		menu.setMnemonic('F');
		init=new JMenuItem("새로 만들기(N)", 'N');
		open=new JMenuItem("열기(O)", 'O');
		save=new JMenuItem("저장(S)", 'S');
		exit=new JMenuItem("끝내기(X)", 'X');
		init.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK));
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_DOWN_MASK));
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));
		menu.add(init);
		menu.add(open);
		menu.add(save);
		menu.addSeparator();
		menu.add(exit);
		bar.add(menu);
		setJMenuBar(bar);
		
		//메모 영역 만들기
		area=new JTextArea();
		area.setFont(new Font("굴림", Font.PLAIN, 16));
		JScrollPane pane=new JScrollPane(area);
		getContentPane().add(pane, BorderLayout.CENTER);
		
		openDialog=new FileDialog(this, "열기", FileDialog.LOAD);
		saveDialog=new FileDialog(this, "저장", FileDialog.SAVE);
		
		//이벤트 핸들러 연결
		init.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		
		//JTextArea 컴퍼넌트에서 키보드 이벤트가 발생된 경우 실행될 이벤트 핸들러 등록
		// => 이벤트 핸들러를 Anonymous Inner Type으로 등록
		area.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//이벤트 발생 키보드의 문자값이 NULL이 아닌 경우
				if(e.getKeyChar()!='\0' && !state) {
					state=true;//상태 변경
					setTitle("* "+getTitle());//프레임 제목 변경
				}
			}
		});
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		//프레임의 닫기 버튼을 누른 경우 실행될 이벤트 핸들러 등록
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(!saveConfirm()) return;
				System.exit(0);
			}
		});
		
		setBounds(450, 150, 1000, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NotepadApp("제목 없음 - Java 메모장");
	}//end of main

	@Override
	public void actionPerformed(ActionEvent e) {
		Object eventSource=e.getSource();
		
		if(eventSource==init) {
			//선택 다이얼로그에서 취소 또는 창닫기를 선택한 경우 이벤트 핸들러 메소드 종료
			if(!saveConfirm()) return;
			
			//JTextArea 컴퍼넌트 초기화
			area.setText("");
			//파일 경로 초기화
			filePath=null;
			//프레임의 제목 변경
			setTitle("제목 없음 - Java 메모장");
		} else if(eventSource==open) {
			if(!saveConfirm()) return;
			
			//열기 관련 FileDialog 컴퍼넌트를 화면에 출력
			// => 파일을 선택하거나 선택을 취소한 경우 FileDialog 컴퍼넌트는 자동으로 숨김 처리
			openDialog.setVisible(true);
			
			//FileDialog 컴퍼넌트에서 선택을 취소한 경우 이벤트 핸들러 메소드 종료
			//FileDialog.getFile() : 선택 파일명을 반환하는 메소드
			if(openDialog.getFile()==null) return;
			
			//선택 파일의 경로를 반환받아 필드에 저장
			//FileDialog.getDirectory() : 선택 파일이 저장된 폴더 경로를 반환하는 메소드
			filePath=openDialog.getDirectory()+openDialog.getFile();
			
			try {
				//파일 입력 스트림을 생성하여 저장 - FileNotFoundException 발생
				BufferedReader in=new BufferedReader(new FileReader(filePath));
				
				//선택 파일명을 이용하여 프레임의 제목 변경
				setTitle(openDialog.getFile()+" - Java 메모장");
				
				//JTextArea 컴퍼넌트 초기화
				area.setText("");
				
				//파일에 저장된 값을 읽어 JTextArea 컴퍼넌트에 출력
				// => 파일 내용을 한 줄씩 읽어 JTextArea 컴퍼넌트에 추가 - 반복 처리
				while(true) {
					//파일 입력 스트림으로 엔터(Enter) 전까지의 문자 데이타들을 읽어 문자열로 반환하여 저장
					String text=in.readLine();
					if(text==null) break;
					area.append(text+"\n");
				}
				
				//JTextArea 컴퍼넌트의 커서를 처음 위치로 변경
				//JTextArea.setCaretPosition(int position) : 커서 위치를 변경하는 메소드
				area.setCaretPosition(0);
								
				in.close();
			} catch (FileNotFoundException exception) {
				JOptionPane.showMessageDialog(this, "선택한 파일이 존재하지 않습니다."
						,"에러",JOptionPane.ERROR_MESSAGE);
			} catch (IOException exception) {
				JOptionPane.showMessageDialog(this, "프로그램에 문제가 발생 하였습니다."
						,"에러",JOptionPane.ERROR_MESSAGE);
			}
		} else if(eventSource==save) {
			if(filePath==null) {//현재 편집중인 파일이 없는 경우
				//저장 관련 FileDialog 컴퍼넌트를 화면에 출력
				saveDialog.setVisible(true);
				
				//FileDialog 컴퍼넌트에서 선택을 취소한 경우 이벤트 핸들러 메소드 종료
				if(saveDialog.getFile()==null) return;
				
				//선택 파일의 경로를 반환받아 필드에 저장
				filePath=saveDialog.getDirectory()+saveDialog.getFile();
				
				//선택 파일명을 이용하여 프레임의 제목 변경
				setTitle(saveDialog.getFile()+" - Java 메모장");
			}
			
			try {
				//파일 출력 스트림을 생성하여 저장
				BufferedWriter out=new BufferedWriter(new FileWriter(filePath));
				
				//JTextArea 컴퍼넌트의 모든 문자열을 반환받아 저장
				String text=area.getText();
				
				//파일 출력 스트림에 문자열을 전달하여 저장
				out.write(text);
				
				out.close();
			} catch (IOException exception) {
				JOptionPane.showMessageDialog(this, "프로그램에 문제가 발생 하였습니다."
						,"에러",JOptionPane.ERROR_MESSAGE);
			}
			
		} else if(eventSource==exit) {
			if(!saveConfirm()) return;
			System.exit(0);
		}
	}//end of actionPerformed()
	
	//JTextArea 컴퍼넌트의 내용 변경에 대한 저장 유무를 선택 처리하기 위한 메소드
	// => 선택 다이얼로그를 출력하여 저장 유무 선택 처리
	// => 반환값 - false : 창닫기 또는 취소, true : 저장 또는 미저장
	// => [새로 만들기],[열기],[끝내기] JMenuItem 컴퍼넌트를 선택한 경우 호출
	public boolean saveConfirm() {
		if(state) {//JTextArea 컴퍼넌트의 내용이 변경된 경우
			//JOptionPane.showConfirmDialog(Component parent, Object Message
			//, String title, int optionType) : 선택 다이얼로그를 출력하는 메소드
			// => 선택값(정수값) 반환
			int choice=JOptionPane.showConfirmDialog(this, "변경된 내용을 저장 하시겠습니까?"
					, "확인", JOptionPane.YES_NO_CANCEL_OPTION);
			
			if(choice==JOptionPane.YES_OPTION) {//예(저장)을 선택한 경우
				if(filePath==null) {
					saveDialog.setVisible(true);
					if(saveDialog.getFile()==null) return false;
					filePath=saveDialog.getDirectory()+saveDialog.getFile();
					setTitle(saveDialog.getFile()+" - Java 메모장");
				}
				
				try {
					BufferedWriter out=new BufferedWriter(new FileWriter(filePath));
					String text=area.getText();
					out.write(text);
					out.close();
				} catch (IOException exception) {
					JOptionPane.showMessageDialog(this, "프로그램에 문제가 발생 하였습니다."
							,"에러",JOptionPane.ERROR_MESSAGE);
				}
				
			} else if(choice==JOptionPane.CLOSED_OPTION || choice==JOptionPane.CANCEL_OPTION) {
				//창닫기 또는 취소를 선택한 경우
				return false;
			}
		}
		//저장 또는 미저장을 선택한 경우
		state=false;//변경 상태 초기화
		return true;
	}//end of saveConfirm()
}//end of class