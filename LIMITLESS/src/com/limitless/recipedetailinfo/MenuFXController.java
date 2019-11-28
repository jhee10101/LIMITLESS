 /**
 * @Class Name : MenuFXController.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019-05-29           최초생성
 *
 * @author 개발프레임웍크 실행환경 HR. 	LIMITLESS개발팀
 * @since 2019-05-29 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.limitless.recipedetailinfo;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author sist
 *
 */
public class MenuFXController implements Initializable {
	
	@FXML	ComboBox<String> langComboBox;
	
	@FXML	Button	 reSearchBtn;
	@FXML	Button	 reBookmarkBtn;
	@FXML	Button	 userBoardBtn;
	@FXML	Button	 userUpdateBtn;
	@FXML	Button	 logoutBtn;
	@FXML	Button	 engBtn;
	
	
	@Override
	public void initialize(URL var1, ResourceBundle var2) {
		
		reSearchBtn.setOnAction(reSearch -> handlerReSearchBtn(reSearch));
		reBookmarkBtn.setOnAction(reBookmark -> handlerReBookmarkdBtn(reBookmark));
		userBoardBtn.setOnAction(userBoard -> handlerUserBoardBtn(userBoard));
		logoutBtn.setOnAction(logout -> handlerLogoutBtn(logout));
		userUpdateBtn.setOnAction(userUpdate -> handlerUserUpdateBtn(userUpdate));
		engBtn.setOnAction(engChange -> handlerEngBtn(engChange));
		
	}
	
	public void handlerReSearchBtn(ActionEvent reSearch){
		try{
			Parent searchRecipe1Fx;
			searchRecipe1Fx = FXMLLoader.load(getClass().getResource("SearchRecipe1FX.fxml"));
			//외부 css로딩
			searchRecipe1Fx.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인

			Scene scene = new Scene(searchRecipe1Fx);
			Stage primaryStage = (Stage)reSearchBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
						
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public void handlerUserBoardBtn(ActionEvent userBoard){
		try{
			Parent userBoardFx;
			userBoardFx = FXMLLoader.load(getClass().getResource("/com/limitless/userboard1/UserBoardFX.fxml"));
			//외부 css로딩
			userBoardFx.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
			Scene scene = new Scene(userBoardFx);
			Stage primaryStage = (Stage)userBoardBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
						
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public void handlerLogoutBtn(ActionEvent logout){
		try{
			Parent loginFx;
			loginFx = FXMLLoader.load(getClass().getResource("/com/hr/eclass/member/domain/loginFX.fxml"));
			//외부 css로딩
			loginFx.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
			Scene scene = new Scene(loginFx);
			Stage primaryStage = (Stage)logoutBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
						
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void handlerUserUpdateBtn(ActionEvent userUpdate){
		try{
			Parent userUpdateFx;
			userUpdateFx = FXMLLoader.load(getClass().getResource("/com/hr/eclass/member/domain/updateFX.fxml"));
			//외부 css로딩
			userUpdateFx.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
			Scene scene = new Scene(userUpdateFx);
			Stage primaryStage = (Stage)userUpdateBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
						
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void handlerReBookmarkdBtn(ActionEvent reBookmark){
		try{
			Parent reBookmarkFx;
			reBookmarkFx = FXMLLoader.load(getClass().getResource("/com/limitless/recipebookmark/RecipeBookMarkFX.fxml"));
			//외부 css로딩
			reBookmarkFx.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
			Scene scene = new Scene(reBookmarkFx);
			Stage primaryStage = (Stage)reBookmarkBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
						
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public void handlerEngBtn(ActionEvent engChange){
		
		try {
			Parent engChangeFx = FXMLLoader.load(getClass().getResource("MenuFX2.fxml"));
			//외부 css로딩
			engChangeFx.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
			Scene scene = new Scene(engChangeFx);
			Stage primaryStage = (Stage)engBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
