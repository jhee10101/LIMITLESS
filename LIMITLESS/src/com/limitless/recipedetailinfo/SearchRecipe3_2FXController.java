 /**
 * @Class Name : SearchRecipe3_2FXController.java
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.hr.eclass.cmn.HRConst;
import com.limitless.reciperesearch.RecipeResearchDao;
import com.limitless.reciperesearch.RecipeResearchVO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;





/**
 * @author sist
 *
 */
public class SearchRecipe3_2FXController implements Initializable {
	
	@FXML 	Button 	food01Btn;
	@FXML 	Button 	food02Btn;

	@FXML	Button	homeBtn;
	@FXML	Button	backBtn;
	
	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL var1, ResourceBundle var2) {
		food01Btn.setOnAction(food01Event -> handlerfood01Btn(food01Event));
		food02Btn.setOnAction(food02Event -> handlerfood02Btn(food02Event));
		backBtn.setOnAction(backEvent -> handlerBackBtn(backEvent));
		homeBtn.setOnAction(homeEvent -> handlerHomeBtn(homeEvent));
		
	}
	
	
	
	public void handlerfood01Btn(ActionEvent food01Event){
		
		try {
			//임시 값에 Food에 닭 입력
			HRConst.recipeResearchVOTmp.setFood("닭");
			System.out.println(HRConst.recipeResearchVOTmp.toString());
			
			//RecipeResearchDao
			RecipeResearchDao recipeResearchDao = new RecipeResearchDao();
			RecipeResearchVO re = new RecipeResearchVO();
			re = HRConst.recipeResearchVOTmp;
			
			recipeResearchDao.do_retrieve(re);
			List list = new ArrayList<>(recipeResearchDao.do_retrieve(re));
			HRConst.reRetmpVO01 = (RecipeResearchVO) list.get(0);
			
			System.out.println("list:"+HRConst.reRetmpVO01);
			HRConst.reRetmpVO01.getReNo();
			System.out.println("reNo:"+HRConst.reRetmpVO01.getReNo());
			
			HRConst.reRetmpVO02=(RecipeResearchVO) list.get(1);
			System.out.println("list:"+HRConst.reRetmpVO02);
			HRConst.reRetmpVO02.getReNo();
			System.out.println("reNo:"+HRConst.reRetmpVO02.getReNo());
			
			
			
			//화면 전환
			Parent recipeSearchOkFx;
			recipeSearchOkFx = FXMLLoader.load(getClass().getResource("RecipeSearchOkFX.fxml"));
			//외부 css로딩
			recipeSearchOkFx.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
			Scene scene = new Scene(recipeSearchOkFx);
			Stage primaryStage = (Stage)food01Btn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void handlerfood02Btn(ActionEvent food02Event){
		try {
			
			HRConst.recipeResearchVOTmp.setFood("돼지");
			System.out.println(HRConst.recipeResearchVOTmp.toString());
			
			//RecipeResearchDao
			RecipeResearchDao recipeResearchDao = new RecipeResearchDao();
			RecipeResearchVO re = new RecipeResearchVO();
			re = HRConst.recipeResearchVOTmp;
			
			recipeResearchDao.do_retrieve(re);
			List list = new ArrayList<>(recipeResearchDao.do_retrieve(re));
			HRConst.reRetmpVO01 = (RecipeResearchVO) list.get(0);
			
			System.out.println("list:"+HRConst.reRetmpVO01);
			HRConst.reRetmpVO01.getReNo();
			System.out.println("reNo:"+HRConst.reRetmpVO01.getReNo());
			
			HRConst.reRetmpVO02=(RecipeResearchVO) list.get(1);
			System.out.println("list:"+HRConst.reRetmpVO02);
			HRConst.reRetmpVO02.getReNo();
			System.out.println("reNo:"+HRConst.reRetmpVO02.getReNo());
			
			
			
			//화면 전환
			Parent recipeSearchOkFx;
			recipeSearchOkFx = FXMLLoader.load(getClass().getResource("RecipeSearchOkFX.fxml"));
			//외부 css로딩
			recipeSearchOkFx.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
			Scene scene = new Scene(recipeSearchOkFx);
			Stage primaryStage = (Stage)food02Btn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			
			
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
	
	public void handlerBackBtn(ActionEvent backEvent) {
		try {
			Parent searchRecipe2_2Fx;
			searchRecipe2_2Fx = FXMLLoader.load(getClass().getResource("SearchRecipe2_2FX.fxml"));
			//외부 css로딩
			searchRecipe2_2Fx.getStylesheets().add(getClass().getResource("app.css").toString()); //로딩여부 확인
			Scene scene = new Scene(searchRecipe2_2Fx);
			Stage primaryStage = (Stage)backBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
