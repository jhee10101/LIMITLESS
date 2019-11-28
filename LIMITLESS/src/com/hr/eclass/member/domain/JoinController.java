package com.hr.eclass.member.domain;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.hr.eclass.member.dao.MemberEClassDao;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class JoinController implements Initializable {
	//회원가입
	@FXML private TextField id_join;
	@FXML private TextField email;
	@FXML private TextField name;
	@FXML private PasswordField pw_join;
	@FXML private PasswordField pw_join_cfrm;
	@FXML private Button joinCompleteBtn;
	@FXML private Button backBtn;
	
	private Alert alert;	
	
	
	
	 //Dao
    MemberEClassDao dao = new MemberEClassDao();
    MemberEClassVO vo = new MemberEClassVO();
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 경고창
		alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("INFORMATION");
		alert.setHeaderText("LIMITLESS");
		
		// 이벤트감지
		joinCompleteBtn.setOnAction(event->handlerJoinCompleteBtnAction(event));
		backBtn.setOnAction(event->handlerBackBtnAction(event));
		
		
	}
	
	
	
	// joinCompleteBtn 이벤트처리
	public void handlerJoinCompleteBtnAction(ActionEvent event){
		
		//빈칸이 있는 경우
		if(id_join.getText().trim().equals("")
				|| pw_join.getText().trim().equals("")
				|| pw_join_cfrm.getText().trim().equals("")
				|| email.getText().trim().equals("")
				|| name.getText().trim().equals("")){
			
			alert.setContentText("빈칸을 입력하세요.");
			alert.show();
			
			return;
			
		}
		
			
		
		//비밀번호 확인 불일치 경우
		if( !(pw_join_cfrm.getText().trim().equals(pw_join.getText())) ){
			alert.setContentText("비밀번호를 확인하세요.");
			alert.show();
			
			pw_join.requestFocus();
			return; //리턴값을 안 주면 틀려도 결과가 나옴. 따라서 리턴을 꼭 줘야함!!
		}
		
		
		
		MemberEClassVO memberEClassVO = new MemberEClassVO();
		memberEClassVO.setGroupDiv("3");
		memberEClassVO.setId(id_join.getText().trim());
		memberEClassVO.setPw(pw_join.getText().trim());
		memberEClassVO.setEmail(email.getText().trim());
		memberEClassVO.setName(name.getText().trim());
		
		

		MemberEClassVO member = dao.memberJoin(memberEClassVO);
		System.out.println("===========================");
		System.out.println("member:"+member.getMessage());
		System.out.println("===========================");  
		
		
		
		if(member.getMessageDiv()=="10"){
			alert.setContentText("아이디가 존재합니다.");
			alert.show();
		}else if(member.getMessageDiv()=="00"){
			alert.setContentText(member.getMessage());
			alert.showAndWait();
			
			//수정하면 다시 회원정보수정 첫 화면
			Stage login = new Stage();
			
			try {
				Stage stage = (Stage) joinCompleteBtn.getScene().getWindow();
				stage.close();
				Parent root = FXMLLoader.load(getClass().getResource("loginFX.fxml"));
				//외부 css로딩
				root.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
				Scene scene1 = new Scene(root);
				login.setTitle("Event");
				login.setScene(scene1);
				login.show();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
		
	}
	
	
	
	
	// backBtn 이벤트처리
	public void handlerBackBtnAction(ActionEvent event){
	
		Stage back = new Stage();
		
		try {
			Stage stage = (Stage) backBtn.getScene().getWindow();
			stage.close();
			Parent root = FXMLLoader.load(getClass().getResource("loginFX.fxml"));
			//외부 css로딩
			root.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
			Scene scene = new Scene(root);
			back.setTitle("Event");
			back.setScene(scene);
			back.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		

	}
	

	
	

}
