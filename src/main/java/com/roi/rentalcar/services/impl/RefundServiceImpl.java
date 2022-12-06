package com.roi.rentalcar.services.impl;

import com.roi.rentalcar.database.entities.Refund;
import com.roi.rentalcar.database.repositories.RefundRepo;
import com.roi.rentalcar.dto.RefundDTO;
import com.roi.rentalcar.mappers.RefundMapper;
import com.roi.rentalcar.services.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefundServiceImpl implements RefundService {
    @Autowired
    private RefundMapper refundMapper;
    @Autowired
    private RefundRepo refundRepo;

    @Override
    public RefundDTO getById(Long id) {
        Refund refund = refundRepo.findById(id).orElseThrow(() ->
                new RuntimeException("The refund with this id " + id + "does not exist"));
        return refundMapper.toDTO(refund);
    }

    @Override
    public List<RefundDTO> getAll() {
        return refundMapper.toDTOList(refundRepo.findAll());
    }

    @Override
    public RefundDTO create(RefundDTO refundDTO) {
        if (refundDTO.getRefundId()!=null) throw new RuntimeException("Id must be null");
        Refund refund=refundMapper.toEntity(refundDTO);
        refundRepo.save(refund);
        return refundMapper.toDTO(refund);
    }

    @Override
    public RefundDTO update(RefundDTO refundDTO) {
        if (refundDTO.getRefundId()==null)throw new RuntimeException("Id must not be null");
        Refund refund = refundRepo.findById(refundDTO.getRefundId()).orElseThrow(()->
                new RuntimeException("The refund with this id " + refundDTO.getRefundId() + "does not exist"));
        refund.setComment(refundDTO.getComment());
        refund.setReturnDate(refundDTO.getReturnDate());
        refund.setSurcharge(refund.getSurcharge());
        refund.setRefund(refundDTO.getRefund());
        refundRepo.save(refund);
        return refundMapper.toDTO(refund);
    }

    @Override
    public String delete(Long id) {
        try {
            if (refundRepo.findById(id).isEmpty())
                throw new RuntimeException("Refund with this id " + id + "does not exist");
            refundRepo.deleteById(id);
            return "The refund with the id " + id + "has been deleted.";
        } catch (Exception e) {
            return "Something went wrong.Please contact administrator.";
        }
    }
}
