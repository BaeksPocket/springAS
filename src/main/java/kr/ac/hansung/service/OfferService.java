package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.OfferDAO;
import kr.ac.hansung.model.Offer;

@Service
public class OfferService {

	@Autowired
	private OfferDAO offerDao;

	public List<Offer> getCurrent() {

		return offerDao.getOffers1();

	}

	public List<Offer> getCurrent2() {

		return offerDao.getOffers2(); // 과목 리스트 가져오기

	}

	public void insert(Offer offer) {
		offerDao.insert(offer);

	}

	public List<Offer> getGradeSum() {
		// TODO Auto-generated method stub
		return offerDao.getOffers3();
	}

	public List<Offer> getPutin() {
		// TODO Auto-generated method stub
		return offerDao.getOffers4();
	}

	public List<Offer> getDetail(int year, int semester) {
		// TODO Auto-generated method stub
		return offerDao.getOffers5(year,semester);
	}


}
