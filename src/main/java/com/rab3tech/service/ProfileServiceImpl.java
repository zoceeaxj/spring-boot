package com.rab3tech.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rab3tech.controller.dto.ProfileDTO;
import com.rab3tech.controller.dto.ProfileDaoRepository;
import com.rab3tech.dao.ProfileEntity;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileDaoRepository daoRepository;


	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProfileDTO> sortProfiles(String sort) {
		List<ProfileEntity> list=daoRepository.findAllByOrderByEmailAsc();
		List<ProfileDTO> profileDTOs= convertList(list);
		return profileDTOs;
	}

	private List<ProfileDTO> convertList(List<ProfileEntity> list) {
		List<ProfileDTO> profileDTOs=new ArrayList<ProfileDTO>();
		for(ProfileEntity entity:list){
			ProfileDTO profileDTO=new ProfileDTO();
			BeanUtils.copyProperties(entity, profileDTO);
			profileDTOs.add(profileDTO);
		}
		return profileDTOs;
	}

	@Override
	public List<String> findAllQualification() {
		
		return daoRepository.findMyQualification();
	}

	@Override
	public List<ProfileDTO> filterProfiles(String filterText) {
		List<ProfileEntity> list=daoRepository.filterProfiles(filterText);
		List<ProfileDTO> profileDTOs= convertList(list);
		return profileDTOs;
	}

	@Override
	public List<ProfileDTO> searchProfiles(String search) {
		return null;
	}

	@Override
	public List<ProfileDTO> findAll() {
		List<ProfileEntity> list=daoRepository.findAll();
		List<ProfileDTO> profileDTOs= convertList(list);
		return profileDTOs;
	}

	@Override
	public ProfileDTO authUser(String pusername, String ppassword) {
		Optional <ProfileEntity> optional = daoRepository.findByUsernameAndPassword(pusername, ppassword);
		return convertToDTO(optional);
	}
	
	private ProfileDTO convertToDTO (Optional<ProfileEntity> optional) {
		
		ProfileDTO profileDTO = null;
		if (optional.isPresent()) {
			ProfileEntity profileEntity = optional.get();
			profileDTO = new ProfileDTO();
			BeanUtils.copyProperties(profileEntity, profileDTO);
		}
		return profileDTO;
		
	}

	@Override
	public ProfileDTO findByEmail(String pemail) {
		Optional<ProfileEntity> optional = daoRepository.findByEmail(pemail);
		return convertToDTO(optional);
	}

	@Override
	public ProfileDTO findByUsername(String pusername) {
		ProfileEntity profileEntity=daoRepository.findById(pusername).get();
		ProfileDTO profileDTO=new ProfileDTO();
		BeanUtils.copyProperties(profileEntity, profileDTO);
		return profileDTO;
	}

	@Override
	public void deleteByUsername(String pusername) {
		daoRepository.deleteById(pusername);
		
	}

	@Override
	public String findPasswordByUsernameOrEmail(String usernameEmail) {
		ProfileEntity entity=daoRepository.findByUsernameOrEmail(usernameEmail, usernameEmail);
		return entity.getPassword();
	}

	@Override
	public String icreateSignup(ProfileDTO profileDTO) {
		ProfileEntity entity=new ProfileEntity();
		BeanUtils.copyProperties(profileDTO, entity);
		//String result =  profileDao.icreateSignup(entity);
		try {
			entity.setTphoto(profileDTO.getFile().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		daoRepository.save(entity);
		return "success";
	}

	@Override
	@Deprecated
	public List<ProfileDTO> findAllWithPhoto() {
		return null;
	}

	@Override
	public byte[] findPhotoByUsername(String pusername) {
		//return profileDao.findPhotoByUsername(pusername);
		return daoRepository.findById(pusername).get().getTphoto();
	}

	@Override
	public String updatePhoto(ProfileDTO profileDTO) {
		
		ProfileEntity profileEntity=daoRepository.findById(profileDTO.getUsername()).get();
		try {
			profileEntity.setTphoto(profileDTO.getFile().getBytes());
		} catch (IOException e) {
		}
		return "success";
		
	}

}
