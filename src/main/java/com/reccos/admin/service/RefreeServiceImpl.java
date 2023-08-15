package com.reccos.admin.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.reccos.admin.dto.RefreeRequest;
import com.reccos.admin.dto.RefreeResponse;
import com.reccos.admin.exceptions.core.RefreeNotFoundException;
import com.reccos.admin.mapper.RefreeMapper;
import com.reccos.admin.repository.RefreeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RefreeServiceImpl implements RefreeService {

    private final RefreeMapper refreeMapper;
    private final RefreeRepository refreeRepository;

    @Override
    public List<RefreeResponse> listAll() {
        return refreeRepository.findAll()
                .stream()
                .map(refreeMapper::toRefreeResponse)
                .toList();
    }

    @Override
    public RefreeResponse RefreeById(Long refree_id) {
        return refreeRepository.findById(refree_id)
                .map(refreeMapper::toRefreeResponse)
                .orElseThrow(RefreeNotFoundException::new);
    }

    @Override
    public RefreeResponse createRefree(RefreeRequest refreeRequest) {
        var newRefree = refreeMapper.toRefree(refreeRequest);
        var createdRefree = refreeRepository.save(newRefree);
        return refreeMapper.toRefreeResponse(createdRefree);
    }

    @Override
    public RefreeResponse updateRefree(RefreeRequest refreeRequest, Long refree_id) {
        var refree = refreeRepository.findById(refree_id)
                .orElseThrow(RefreeNotFoundException::new);
        BeanUtils.copyProperties(refreeRequest, refree, "id", "createdAt", "updatedAt");
        var refreeUpdate = refreeRepository.save(refree);
        return refreeMapper.toRefreeResponse(refreeUpdate);
    }

    @Override
    public void deleteRefree(Long refree_id) {
        refreeRepository.deleteById(refree_id);
    }

}
