package com.filmrental.service;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrental.entity.Address;
import com.filmrental.entity.Payment;
import com.filmrental.entity.Rental;
import com.filmrental.entity.Staff;
import com.filmrental.model.AddressModel;
import com.filmrental.model.CityModel;
import com.filmrental.model.CountryModel;
import com.filmrental.model.PaymentModel;
import com.filmrental.model.RentalModel;
import com.filmrental.model.StaffModel;
import com.filmrental.model.StoreModel;
import com.filmrental.repository.StaffRepo;
 
@Service
public class StaffServiceImpl implements StaffService {
 
	@Autowired
	private StaffRepo staffRepo;
	
	
	@Override
    public String addNewStaff(StaffModel staffModel) {
        Staff staff = new Staff();
        BeanUtils.copyProperties(staffModel, staff);
        List<Rental> rentals = new ArrayList<>();
        if (staffModel .getRentals() != null) {
        	for (RentalModel rentalModel : staffModel.getRentals()) {
        		Rental rental = new Rental();
        		BeanUtils.copyProperties(rentalModel, rental);
        		rentals.add(rental);
        	}
        }
        staff.setAllRentals(rentals);
        List<Payment> payments = new ArrayList<>();
        if (staffModel .getAllPayments() != null) {
        	for (PaymentModel paymentModel : staffModel.getAllPayments()) {
        		Payment payment = new Payment();
                BeanUtils.copyProperties(paymentModel, payment);
                payments.add(payment);
        	}
        }
        staff.setAllPayments(payments);
        staffRepo.save(staff);
        return "staff added";
	}

	@Override
	public List<StaffModel> findByLastName(String lastName) {
	    List<Staff> staffList = staffRepo.findByLastName(lastName);
	    List<StaffModel> staffModels = new ArrayList<>();

	    for (Staff staff : staffList) {
	        StaffModel staffModel = new StaffModel();
	        BeanUtils.copyProperties(staff, staffModel);

	        List<RentalModel> rentalModels = new ArrayList<>();
	        if (staff.getAllRentals() != null) {
	            for (Rental rental : staff.getAllRentals()) {
	                RentalModel rentalModel = new RentalModel();
	                BeanUtils.copyProperties(rental, rentalModel);

	                List<PaymentModel> rentalPaymentModels = new ArrayList<>();
	                if (rental.getPayments() != null) {
	                    for (Payment payment : rental.getPayments()) {
	                        PaymentModel paymentModel = new PaymentModel();
	                        BeanUtils.copyProperties(payment, paymentModel);
	                        rentalPaymentModels.add(paymentModel);
	                    }
	                }
	                rentalModel.setPayments(rentalPaymentModels);
	                rentalModels.add(rentalModel);
	            }
	        }

	        staffModel.setRentals(rentalModels);

	        List<PaymentModel> paymentModels = new ArrayList<>();
	        if (staff.getAllPayments() != null) {
	            for (Payment payment : staff.getAllPayments()) {
	                PaymentModel paymentModel = new PaymentModel();
	                BeanUtils.copyProperties(payment, paymentModel);
	                paymentModels.add(paymentModel);
	            }
	        }

	        staffModel.setAllPayments(paymentModels);
	        staffModels.add(staffModel);
	    }

	    return staffModels;
	}

	@Override
	public List<StaffModel> findByFirstName(String FirstName) {
		 List<Staff> staffList = staffRepo.findByfirstName(FirstName);
		    List<StaffModel> staffModels = new ArrayList<>();

		    for (Staff staff : staffList) {
		        StaffModel staffModel = new StaffModel();
		        BeanUtils.copyProperties(staff, staffModel);

		        List<RentalModel> rentalModels = new ArrayList<>();
		        if (staff.getAllRentals() != null) {
		            for (Rental rental : staff.getAllRentals()) {
		                RentalModel rentalModel = new RentalModel();
		                BeanUtils.copyProperties(rental, rentalModel);

		                List<PaymentModel> rentalPaymentModels = new ArrayList<>();
		                if (rental.getPayments() != null) {
		                    for (Payment payment : rental.getPayments()) {
		                        PaymentModel paymentModel = new PaymentModel();
		                        BeanUtils.copyProperties(payment, paymentModel);
		                        rentalPaymentModels.add(paymentModel);
		                    }
		                }
		                rentalModel.setPayments(rentalPaymentModels);
		                rentalModels.add(rentalModel);
		            }
		        }

		        staffModel.setRentals(rentalModels);

		        List<PaymentModel> paymentModels = new ArrayList<>();
		        if (staff.getAllPayments() != null) {
		            for (Payment payment : staff.getAllPayments()) {
		                PaymentModel paymentModel = new PaymentModel();
		                BeanUtils.copyProperties(payment, paymentModel);
		                paymentModels.add(paymentModel);
		            }
		        }

		        staffModel.setAllPayments(paymentModels);
		        staffModels.add(staffModel);
		    }

		    return staffModels;
		}

	@Override
	public StaffModel findByEmail(String email) {
	    Staff staff = staffRepo.findByEmail(email);
	    StaffModel staffModel = new StaffModel();
	    BeanUtils.copyProperties(staff, staffModel);

	    List<RentalModel> rentalModels = new ArrayList<>();
	    if (staff.getAllRentals() != null) {
	        for (Rental rental : staff.getAllRentals()) {
	            RentalModel rentalModel = new RentalModel();
	            BeanUtils.copyProperties(rental, rentalModel);

	            List<PaymentModel> rentalPaymentModel = new ArrayList<>();
	            if (rental.getPayments() != null) {
	                for (Payment payment : rental.getPayments()) {
	                    PaymentModel paymentModel = new PaymentModel();
	                    BeanUtils.copyProperties(payment, paymentModel);
	                    rentalPaymentModel.add(paymentModel);
	                }
	                rentalModel.setPayments(rentalPaymentModel);
	                rentalModels.add(rentalModel);
	            }
	        }
	    }

	    staffModel.setRentals(rentalModels);

	    List<PaymentModel> paymentModels = new ArrayList<>();
	    if (staff.getAllPayments() != null) {
	        for (Payment payment : staff.getAllPayments()) {
	            PaymentModel paymentModel = new PaymentModel();
	            BeanUtils.copyProperties(payment, paymentModel);
	            
	            paymentModels.add(paymentModel);
	        }
	    }
	    staffModel.setAllPayments(paymentModels);

	    return staffModel;
	}
	@Override
	public List<StaffModel> findByAddress_City_CityName(String cityName) {
	    List<Staff> staffList = staffRepo.findByAddress_City_CityName(cityName);
	    List<StaffModel> staffModels = new ArrayList<>();

	    for (Staff staff : staffList) {
	        StaffModel staffModel = new StaffModel();
	        BeanUtils.copyProperties(staff, staffModel);

	        if (staff.getAddress() != null) {
	            AddressModel addressModel = new AddressModel();
	            BeanUtils.copyProperties(staff.getAddress(), addressModel);
//	            staffModel.setAddress(addressModel);
	            staffModel.setAddress(addressModel);;

	            if (staff.getAddress().getCity() != null) {
	                CityModel cityModel = new CityModel();
	                BeanUtils.copyProperties(staff.getAddress().getClass(), cityModel);
//	                addressModel.setCity(cityModel);
//	                addressModel.setCity(cityModel);
	            }
	        }

	        staffModels.add(staffModel);
	    }

	    return staffModels;
	}
	@Override
	public List<StaffModel>findByAddress_City_Country_CountryName(String countryName) {
	    List<Staff> staffList = staffRepo.findByAddress_City_Country_CountryName(countryName);
	    List<StaffModel> staffModels = new ArrayList<>();

	    for (Staff staff : staffList) {
	        StaffModel staffModel = new StaffModel();
	        BeanUtils.copyProperties(staff, staffModel);

	        if (staff.getAddress() != null) {
	            AddressModel addressModel = new AddressModel();
	            BeanUtils.copyProperties(staff.getAddress(), addressModel);
	            staffModel.setAddress(addressModel);

	            if (staff.getAddress().getCity() != null) {
	                CityModel cityModel = new CityModel();
	                BeanUtils.copyProperties(staff.getAddress().getCity(), cityModel);
//	                addressModel.setCity(cityModel);

	                if (staff.getAddress().getCity().getCountry() != null) {
	                    CountryModel countryModel = new CountryModel();
	                    BeanUtils.copyProperties(staff.getAddress().getCity().getCountry(), countryModel);
//	                    cityModel.setCountry(countryModel);
	                }
	            }
	        }

	        staffModels.add(staffModel);
	    }
	    return staffModels;
	}
	@Override
	 public StaffModel findByAddress_Phone(String phone) {
	    Staff staff = staffRepo.findByAddress_Phone(phone);

	    if (staff == null) {
	        return null;
	    }

	    StaffModel staffModel = new StaffModel();
	    BeanUtils.copyProperties(staff, staffModel);

	    if (staff.getAddress() != null) {
	        AddressModel addressModel = new AddressModel();
	        BeanUtils.copyProperties(staff.getAddress(), addressModel);
	        staffModel.setAddress(addressModel);

	        if (staff.getAddress().getCity() != null) {
	            CityModel cityModel = new CityModel();
	            BeanUtils.copyProperties(staff.getAddress().getCity(), cityModel);
//	            addressModel.setCity(cityModel);
	        }
	    }
	    return staffModel;
	}	
	
	@Override
	public StaffModel updateFirstNameByStaffId(int staffId, StaffModel newFirstName) {
	    Optional<Staff> optionalStaff = staffRepo.findById(staffId);

	    if (optionalStaff.isPresent()) {
	        Staff staff = optionalStaff.get();
	        staff.setFirstName(newFirstName.getFirstName());
	        Staff updatedStaff = staffRepo.save(staff);

	        StaffModel staffModel = new StaffModel();
	        BeanUtils.copyProperties(updatedStaff, staffModel);
	        return staffModel;
	    } else {
	        return null;
	    }
	}
	
	@Override
    public StaffModel updateLastNameByStaffId(int staffId, StaffModel newLastName) {
        Optional<Staff> optionalStaff = staffRepo.findById(staffId);

        if (optionalStaff.isPresent()) {
            Staff staff = optionalStaff.get();
            staff.setLastName(newLastName.getLastName());
            System.out.println(newLastName.getLastName());
            Staff updatedStaff = staffRepo.save(staff);
            System.out.println(updatedStaff.getLastName());
            StaffModel staffModel = new StaffModel();
            BeanUtils.copyProperties(updatedStaff, staffModel);
            return staffModel;
        } else {
            return null;
        }
    }
	
	@Override
    public StaffModel updateEmailByStaffId(int staffId, StaffModel newEmail) {
        Optional<Staff> optionalStaff = staffRepo.findById(staffId);

        if (optionalStaff.isPresent()) {
            Staff staff = optionalStaff.get();
            staff.setEmail(newEmail.getEmail());
            System.out.println(newEmail.getEmail());
            Staff updatedStaff = staffRepo.save(staff);
            System.out.println(updatedStaff.getEmail());
            StaffModel staffModel = new StaffModel();
            BeanUtils.copyProperties(updatedStaff, staffModel);
            return staffModel;
        } else {
            return null;
        }
    }
	
	@Override
    public StaffModel updatePhoneNumberOfStaffByStaffId(int staffId, StaffModel newPhoneNumber) {
        Optional<Staff> optionalStaff = staffRepo.findById(staffId);

        if (optionalStaff.isPresent()) {
            Staff staff = optionalStaff.get();
            System.out.println("test:" + staff);
            Address address = new Address();
            System.out.println("Hello  "+newPhoneNumber.getAddress());
            System.out.println(newPhoneNumber.getAddress().getPhone());
            
            BeanUtils.copyProperties(newPhoneNumber.getAddress().getPhone(), address);
            
            StaffModel staffModel = new StaffModel();
            BeanUtils.copyProperties(staff, staffModel);
            
//            address.setPhone(newPhoneNumber.getAddress().getPhone());
//            staff.setAddress(address);
//            staffRepo.save(staff);
//            StaffModel staffModel = new StaffModel();
//            BeanUtils.copyProperties(staff, staffModel);
            return staffModel;
        } else {
            return null;
        }
    }
	
	@Override
	public StaffModel assignAddressToStaff(int staffId, AddressModel addressModel) {
	    Optional<Staff> optionalStaff = staffRepo.findById(staffId);

	    if (optionalStaff.isPresent()) {
	        Staff staff = optionalStaff.get();
	        Address address = new Address();
	        BeanUtils.copyProperties(addressModel, address);
	        
	        staff.setAddress(address);
	        staffRepo.saveAndFlush(staff);

	        StaffModel staffModel = new StaffModel();
	        BeanUtils.copyProperties(staff, staffModel);
	        return staffModel;
	    } else {
	        return null;
	    }
	}

	@Override
	public StaffModel assignStoreToStaff(int staffId, StoreModel storeModel) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//@Override
	//public StaffModel assignStoreToStaff(int staffId, StoreModel storeModel) {
	//    Optional<Staff> optionalStaff = staffRepo.findById(staffId);
	    
	  //  if (optionalStaff.isPresent()) {
	  //      Staff staff = optionalStaff.get();
	  //      Store store = new Store();
	  //      BeanUtils.copyProperties(storeModel, store);

	  //      staff.setStore(store);
	  //      staffRepo.saveAndFlush(staff);

	  //      StaffModel staffModel = new StaffModel();
	  //      BeanUtils.copyProperties(staff, staffModel);
	  //      return staffModel;
	  //  } else {
	  //      return null;
	  //  }
	//}


	
}


