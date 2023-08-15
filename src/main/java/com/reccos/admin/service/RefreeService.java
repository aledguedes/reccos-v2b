package com.reccos.admin.service;

import java.util.List;

import com.reccos.admin.dto.RefreeRequest;
import com.reccos.admin.dto.RefreeResponse;

public interface RefreeService {

	List<RefreeResponse> listAll();
    void deleteRefree(Long refree_id);
    RefreeResponse RefreeById(Long refree_id);
    RefreeResponse createRefree(RefreeRequest refreeRequest);
    RefreeResponse updateRefree(RefreeRequest refreeRequest, Long refree_id);
}
