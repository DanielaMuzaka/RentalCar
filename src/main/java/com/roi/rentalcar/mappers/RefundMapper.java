package com.roi.rentalcar.mappers;

import com.roi.rentalcar.database.entities.Refund;
import com.roi.rentalcar.dto.RefundDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RefundMapper implements BaseMapper<Refund, RefundDTO>{
    @Override
    public RefundDTO toDTO(Refund refund) {
        if(refund==null) return null;
        RefundDTO refundDTO = new RefundDTO();
        refundDTO.setRefundId(refund.getRefundId());
        refundDTO.setRefund(refund.getRefund());
        refundDTO.setReturnDate(refund.getReturnDate());
        refundDTO.setComment(refund.getComment());
        refundDTO.setSurcharge(refund.getSurcharge());
        return refundDTO;
    }

    @Override
    public Refund toEntity(RefundDTO refundDTO) {
        if(refundDTO==null) return null;
        Refund refund = new Refund();
        refund.setRefundId(refundDTO.getRefundId());
        refund.setRefund(refundDTO.getRefund());
        refund.setReturnDate(refundDTO.getReturnDate());
        refund.setSurcharge(refundDTO.getSurcharge());
        refund.setComment(refundDTO.getComment());
        return refund;
    }

    @Override
    public List<RefundDTO> toDTOList(List<Refund> e) {
        if(e==null) return null;
        List<RefundDTO > refundDTOList = new ArrayList<>();
        for(Refund refund : e){
            refundDTOList.add(toDTO(refund));
        }
        return refundDTOList;
    }

    @Override
    public List<Refund> toEntityList(List<RefundDTO> d) {
        if(d==null) return null;
        List<Refund> refundList = new ArrayList<>();
        for(RefundDTO refundDTO : d){
            refundList.add(toEntity(refundDTO));

        }
        return refundList;
    }
}
