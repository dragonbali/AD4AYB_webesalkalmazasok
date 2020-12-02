package hu.ad4ayb.web.serv;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.ad4ayb.web.dto.StudentDto;
import hu.ad4ayb.web.rep.ListingRepository;



@Service
public class ListingService implements InterfaceListingService {

    @Autowired
    ListingRepository listingRepository;

    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    public Boolean notOrLate(Date deadline, Date receiptTime) {
        return listingRepository.notOrLate(deadline, receiptTime);
    }

    public List < Boolean > isOkList(List < StudentDto > students) {
        return listingRepository.isOkList(students);
    }

    public List < StudentDto > getStudents() {
        return listingRepository.getStudents();
    }
}