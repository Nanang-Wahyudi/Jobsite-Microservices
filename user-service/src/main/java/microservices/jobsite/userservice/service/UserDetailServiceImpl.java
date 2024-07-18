package microservices.jobsite.userservice.service;

import microservices.jobsite.userservice.entity.UserDetail;
import microservices.jobsite.userservice.model.request.CreateUserDetailAndCompanyRequest;
import microservices.jobsite.userservice.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public void createUserDetail(CreateUserDetailAndCompanyRequest userDetailRequest) {
        UserDetail userDetail = UserDetail.builder()
                .name(userDetailRequest.getName())
                .userId(userDetailRequest.getUserId())
                .build();
        userDetailRepository.save(userDetail);
    }

}
