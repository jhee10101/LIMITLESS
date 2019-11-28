 /**
 * @Class Name : SearchRecipe2_1FXController.java
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
import java.util.ResourceBundle;

import com.hr.eclass.cmn.HRConst;
import com.limitless.reciperesearch.RecipeResearchVO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author sist
 *
 */
public class SearchRecipe2_1FXController implements Initializable {
	@FXML	Button	dish01Btn;
	@FXML	Button	dish02Btn;
	@FXML	Button	dish03Btn;
	@FXML	Button  homeBtn;
	@FXML	Button	backBtn;
	
	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL var1, ResourceBundle var2) {
		dish01Btn.setOnAction(dish01Event -> handlerDish01Btn(dish01Event));
		dish02Btn.setOnAction(dish02Event -> handlerDish02Btn(dish02Event));
		dish03Btn.setOnAction(dish03Event -> handlerDish03Btn(dish03Event));
		homeBtn.setOnAction(homeEvent -> handlerHomeBtn(homeEvent));
		backBtn.setOnAction(backEvent -> handlerBackBtn(backEvent));
	}




	public void  handlerDish01Btn(ActionEvent dish01Event){
			
			try {
				Parent searchRecipe3_1Fx;
				searchRecipe3_1Fx = FXMLLoader.load(getClass().getResource("SearchRecipe3_1FX.fxml"));
				//외부 css로딩
				searchRecipe3_1Fx.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
				Scene scene = new Scene(searchRecipe3_1Fx);
				Stage primaryStage = (Stage)dish01Btn.getScene().getWindow();
				primaryStage.setScene(scene);
				primaryStage.show();
				
				HRConst.recipeResearchVOTmp.setDish("한그릇 음식");
				System.out.println(HRConst.recipeResearchVOTmp.toString());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	
	public void  handlerDish02Btn(ActionEvent dish02Event){
		
		try {
			Parent searchRecipe3_1Fx;
			searchRecipe3_1Fx = FXMLLoader.load(getClass().getResource("SearchRecipe3_1FX.fxml"));
			//외부 css로딩
			searchRecipe3_1Fx.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
			Scene scene = new Scene(searchRecipe3_1Fx);
			Stage primaryStage = (Stage)dish02Btn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
			
			HRConst.recipeResearchVOTmp.setDish("국물요리");
			System.out.println(HRConst.recipeResearchVOTmp.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void  handlerDish03Btn(ActionEvent dish03Event){
		
		try {
			Parent searchRecipe3_1Fx;
			searchRecipe3_1Fx = FXMLLoader.load(getClass().getResource("SearchRecipe3_1FX.fxml"));
			//외부 css로딩
			searchRecipe3_1Fx.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
			Scene scene = new Scene(searchRecipe3_1Fx);
			Stage primaryStage = (Stage)dish03Btn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
			
			HRConst.recipeResearchVOTmp.setDish("반찬");
			System.out.println(HRConst.recipeResearchVOTmp.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void handlerHomeBtn(ActionEvent homeEvent) {
		
		try {
			Parent menuFx;
			menuFx = FXMLLoader.load(getClass().getResource("MenuFx.fxml"));
			//외부 css로딩
			menuFx.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
			Scene scene = new Scene(menuFx);
			Stage primaryStage = (Stage)homeBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void handlerBackBtn(ActionEvent backEvent){
		try{
			Parent searchRecipe1Fx;
			searchRecipe1Fx = FXMLLoader.load(getClass().getResource("SearchRecipe1FX.fxml"));
			//외부 css로딩
			searchRecipe1Fx.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
			Scene scene = new Scene(searchRecipe1Fx);
			Stage primaryStage = (Stage)backBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
						
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
