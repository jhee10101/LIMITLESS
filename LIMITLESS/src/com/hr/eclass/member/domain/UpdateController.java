package com.hr.eclass.member.domain;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.hr.eclass.member.dao.MemberEClassDao;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UpdateController implements Initializable {
	@FXML Button updateBtn;
	@FXML Button leaveBtn;
	@FXML Button backBtn;
	@FXML TextField id;
	@FXML TextField email;
	@FXML TextField name;
	@FXML PasswordField pw;
	@FXML PasswordField pwCnfm;
	
	private Alert alert;	
	
	MemberEClassDao dao = new MemberEClassDao();
	MemberEClassVO vo = new MemberEClassVO();
	
	
	private Stage primaryStage;
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// 경고창
		alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("INFORMATION");
		alert.setHeaderText("LIMITLESS");
		
		
		updateBtn.setOnAction(event->handlerUpdateBtnAction(event));
		leaveBtn.setOnAction(event->{
			try {
				handlerLeaveBtnAction(event);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		backBtn.setOnAction(event->handlerBackBtnAction(event));
		
	}



	//뒤로가기
	private void handlerBackBtnAction(ActionEvent event) {
		Stage back = new Stage();
		
		try {
			Stage stage = (Stage) backBtn.getScene().getWindow();
			stage.close();
			Parent root = FXMLLoader.load(getClass().getResource("/com/limitless/recipedetailinfo/MenuFX.fxml"));
			//외부 css로딩
			root.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
			Scene scene = new Scene(root);
			back.setScene(scene);
			back.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}





	//탈퇴하기
	private void handlerLeaveBtnAction(ActionEvent event) throws IOException {
		
		
		//빈칸이 있는 경우
		if(id.getText().trim().equals("")
				|| pw.getText().trim().equals("")
				|| pwCnfm.getText().trim().equals("")
				|| email.getText().trim().equals("")
				|| name.getText().trim().equals("")){
			
			alert.setContentText("빈칸을 입력하세요.");
			alert.show();
			
			return;
			
		}
		
		
		//비밀번호 확인 불일치 경우
		if( !(pwCnfm.getText().trim().equals(pw.getText())) ){
			alert.setContentText("비밀번호를 확인하세요.");
			alert.show();
			
			pw.requestFocus();
			return; //리턴값을 안 주면 틀려도 결과가 나옴. 따라서 리턴을 꼭 줘야함!!
		}
		
		
		
		MemberEClassVO memberEClassVO = new MemberEClassVO();
		memberEClassVO.setGroupDiv("3");
		memberEClassVO.setId(id.getText().trim());
		memberEClassVO.setPw(pw.getText().trim());
		memberEClassVO.setPw(pwCnfm.getText().trim());
		memberEClassVO.setEmail(email.getText().trim());
		memberEClassVO.setName(name.getText().trim());
		
		
	
		int member = dao.do_delete(memberEClassVO);
		System.out.println("===========================");
		System.out.println("member:"+member);
		System.out.println("===========================");
		
		alert.setContentText("탈퇴가 완료되었습니다.");
		alert.showAndWait();
	
		
       
    	Stage login = new Stage();
		
		try {
			Stage stage = (Stage) updateBtn.getScene().getWindow();
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





	//수정하기
	private void handlerUpdateBtnAction(ActionEvent event) {
		

		//빈칸이 있는 경우
		if(id.getText().trim().equals("")
				|| pw.getText().trim().equals("")
				|| pwCnfm.getText().trim().equals("")
				|| email.getText().trim().equals("")
				|| name.getText().trim().equals("")){
			
			alert.setContentText("빈칸을 입력하세요.");
			alert.show();
			
			return;
			
		}
		
		
		//비밀번호 확인 불일치 경우
		if( !(pwCnfm.getText().trim().equals(pw.getText())) ){
			alert.setContentText("비밀번호를 확인하세요.");
			alert.show();
			
			pw.requestFocus();
			return; //리턴값을 안 주면 틀려도 결과가 나옴. 따라서 리턴을 꼭 줘야함!!
		}
		
		
		
		
		
		MemberEClassVO memberEClassVO = new MemberEClassVO();
		memberEClassVO.setGroupDiv("3");
		memberEClassVO.setId(id.getText().trim());
		memberEClassVO.setPw(pw.getText().trim());
		memberEClassVO.setPw(pwCnfm.getText().trim());
		memberEClassVO.setEmail(email.getText().trim());
		memberEClassVO.setName(name.getText().trim());
		
	
		int member = dao.do_update(memberEClassVO);
		System.out.println("===========================");
		System.out.println("member:"+member);
		System.out.println("===========================");  
		
		alert.setContentText("회원정보가 수정되었습니다.");
		alert.showAndWait();
		
		
	
		
		
		//수정하면 다시 회원정보수정 첫 화면
		Stage login = new Stage();
		
		try {
			Stage stage = (Stage) updateBtn.getScene().getWindow();
			stage.close();
			Parent root = FXMLLoader.load(getClass().getResource("/com/limitless/recipedetailinfo/MenuFX.fxml"));
			//외부 css로딩
			root.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
			Scene scene1 = new Scene(root);
			
			login.setScene(scene1);
			login.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

	
	
	
	
}
