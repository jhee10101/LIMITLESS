 /**
 * @Class Name : UserBoardDao.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019-05-23           최초생성
 *
 * @author 개발프레임웍크 실행환경 HR. 	LIMITLESS개발팀
 * @since 2019-05-23 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.limitless.userboard1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.hr.address.domain.MemberVO;
import com.limitless.cmn.DTO;
import com.limitless.cmn.WorkDiv;
import com.limitless.reciperesearch.RecipeResearchVO;

public class UserBoardDao implements WorkDiv {
	private List<UserBoardVO> usertmp = new ArrayList<UserBoardVO>();
	private final String file = "//211.238.142.124/hr_data/java03/userBoard.csv"; //파일 읽기
	
		
	public UserBoardDao(){
		
		UserboardConst.userBoard = do_readFile();
	}
	
	public int do_saveFile(){
		int i = 0;
		FileWriter writer = null;
		BufferedWriter bw = null;
		
		try{
			writer =new FileWriter(this.file);
			bw = new BufferedWriter(writer);
			
			Iterator<UserBoardVO> it = UserboardConst.userBoard.iterator();
			String divStr = ",";
			while(it.hasNext()){
				
				UserBoardVO userboardVO = it.next();
				
				StringBuilder br = new StringBuilder();
				br.append(userboardVO.getNo());
				br.append(divStr);
				br.append(userboardVO.getContent());
				br.append(divStr);
				
				br.append(userboardVO.getId());
				br.append(divStr);
				br.append(userboardVO.getNickname());
				br.append(divStr);
				br.append(userboardVO.getDate());
				
				bw.write(br.toString());
				i++;
				if(UserboardConst.userBoard.size() !=i){
					bw.newLine();	
				}
				bw.flush();//buffer비우기 
			}
	
		}catch(IOException io){
			
		}finally{
			if(null !=bw){
				try{
					bw.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		return i;
		
	}
	
	public List<UserBoardVO> do_readFile(){
		List<UserBoardVO> list = new ArrayList<>();
		FileReader reader = null;
		BufferedReader  br=null;
	
		try{
			
			reader = new FileReader(file);
			br	   = new BufferedReader(reader);
			
			String line = "";
			while( (line = br.readLine()) !=null){
				
				String[]tmpVO = line.split(",");
				
				String no		= tmpVO[0];	
				String content  = tmpVO[1];
				String id 	    = tmpVO[2];
				String nickname = tmpVO[3];
				String date 	= tmpVO[4];
				
				
				UserBoardVO uVO = new UserBoardVO(content,id,nickname,date);
				uVO.setNo(no);
				list.add(uVO);
			}
		
		}catch(IOException io){
			
		}finally{
			try {
				if(null != br){
					br.close();
				}
			}catch(IOException io){
				
			}
		}
		
		
		
		return list;
	}

	@Override
	public int do_save(DTO dto) {
		UserBoardVO tmpBoard = (UserBoardVO) dto;
		boolean flag = UserboardConst.userBoard.add(tmpBoard);
		
		int i = 0;
		if(flag)i = 1;
		return i;
	}
		

	@Override
	 public List<DTO> do_retrieve(DTO dto) {
		  List<DTO> list = new ArrayList<>();
		  UserBoardVO inVO= (UserBoardVO)dto;
		  UserBoardVO outVO = null;
			
		  for(int i=0; i<this.usertmp.size();i++){
			  UserBoardVO tmpVO =  usertmp.get(i);
					if(tmpVO.getId().equals(inVO.getId())
							){		
						
						outVO = tmpVO; //결과값 리스트에 저장
						
						
						list.add(outVO);
					}
			}
			return list; 
			
	}
	
	
	
	@Override
	public int do_delete(DTO dto) {
		
		return 0;
	}


	@Override
	public int do_update(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DTO do_selectOne(DTO dto) {
		
		return null;
	}

}	
