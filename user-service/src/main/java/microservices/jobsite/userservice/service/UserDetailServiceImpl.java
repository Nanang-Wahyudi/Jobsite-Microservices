package microservices.jobsite.userservice.service;

import microservices.jobsite.userservice.entity.UserDetail;
import microservices.jobsite.userservice.model.request.CreateUserDetailAndCompanyRequest;
import microservices.jobsite.userservice.model.request.UpdateUserDetailRequest;
import microservices.jobsite.userservice.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    public UserDetail getUserDetailById(String id) {
        return userDetailRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User Detail with ID '" + id + "' Not Found"));
    }

    @Override
    public void createUserDetail(CreateUserDetailAndCompanyRequest userDetailRequest) {
        UserDetail userDetail = UserDetail.builder()
                .name(userDetailRequest.getName())
                .userId(userDetailRequest.getUserId())
                .build();
        userDetailRepository.save(userDetail);
    }

    @Override
    public void updateUserDetail(String id, UpdateUserDetailRequest userDetailRequest) {
        UserDetail userDetail = getUserDetailById(id);
        userDetail.setName(
                userDetailRequest.getName() == null || userDetailRequest.getName().isEmpty()
                ? userDetail.getName() : userDetailRequest.getName()
        );
        userDetail.setAddress(
                userDetailRequest.getAddress() == null || userDetailRequest.getAddress().isEmpty()
                ? userDetail.getAddress() : userDetailRequest.getAddress()
        );
        userDetail.setPicture(
                userDetailRequest.getPicture() == null || userDetailRequest.getPicture().isEmpty()
                ? userDetail.getPicture() : userDetailRequest.getPicture()
        );
        userDetail.setDescription(
                userDetailRequest.getDescription() == null || userDetailRequest.getDescription().isEmpty()
                ? userDetail.getDescription() : userDetailRequest.getDescription()
        );
        userDetailRepository.save(userDetail);
    }

}
