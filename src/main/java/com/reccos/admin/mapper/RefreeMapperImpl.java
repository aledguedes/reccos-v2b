package com.reccos.admin.mapper;

import org.springframework.stereotype.Component;

import com.reccos.admin.dto.RefreeRequest;
import com.reccos.admin.dto.RefreeResponse;
import com.reccos.admin.models.Refree;

@Component
public class RefreeMapperImpl implements RefreeMapper {

    @Override
    public Refree toRefree(RefreeRequest refreeRequest) {
        if (refreeRequest == null) {
            return null;
        }
        return Refree.builder()
                .name(refreeRequest.getName())
                .surname(refreeRequest.getSurname())
                .birth_date(refreeRequest.getBirth_date())
                .status(refreeRequest.getStatus())
                .email(refreeRequest.getEmail())
                .picture_profile(refreeRequest.getPicture_profile())
                .registered_federation(refreeRequest.getRegistered_federation())
                .cpf(refreeRequest.getCpf())
                .rg(refreeRequest.getRg())
                .build();
    }

    @Override
    public RefreeResponse toRefreeResponse(Refree refree) {
        if (refree == null) {
            return null;
        }
        return RefreeResponse.builder()
        		.id(refree.getId())
                .name(refree.getName())
                .surname(refree.getSurname())
                .birth_date(refree.getBirth_date())
                .email(refree.getEmail())
                .status(refree.getStatus())
                .picture_profile(refree.getPicture_profile())
                .registered_federation(refree.getRegistered_federation())
                .federation(refree.getFederation())
	            .createdAt(refree.getCreatedAt())
	            .updatedAt(refree.getUpdatedAt())
                .build();
    }

}
