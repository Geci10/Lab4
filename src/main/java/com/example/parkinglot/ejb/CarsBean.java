package com.example.parkinglot.ejb;
import java.util.ArrayList; 
import com.example.parkinglot.common.CarDto;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.parkinglot.entities.Car;
import org.example.parkinglot.entities.User;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
@Stateless
public class CarsBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());
    @PersistenceContext
    EntityManager entityManager;
    public List<CarDto> findAllCars() {
        LOG.info("findAllCars");
        try {
            TypedQuery<Car> typedQuery = entityManager.createQuery("SELECT c FROM Car c", Car.class);
            List<Car> cars = typedQuery.getResultList();
            return copyCarsToDto(cars);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<CarDto> copyCarsToDto(List<Car> cars) {
        List<CarDto> carDtos = new ArrayList<>();

        for (Car car : cars) {
            CarDto dto = new CarDto(
                    car.getId(),
                    car.getLicensePlate(),
                    car.getParkingSpot(),
                    car.getOwner().getUsername()
            );
            carDtos.add(dto);
        }

        return carDtos;
    }
    public void createCar(String licensePlate, String parkingSpot, Long userId) {
        try {
            // Find the user by ID
            User owner = entityManager.find(User.class, userId);
            if (owner == null) {
                throw new EJBException("No user found with ID: " + userId);
            }

            // Create and populate new Car entity
            Car car = new Car();
            car.setLicensePlate(licensePlate);
            car.setParkingSpot(parkingSpot);
            car.setOwner(owner);

            // OPTIONAL: maintain bidirectional relationship if User has List<Car>
            owner.getCars().add(car);

            // Persist new car in DB
            entityManager.persist(car);

        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

        public CarDto findById(Long carId) {
            Car car = entityManager.find(Car.class, carId);
            if (car == null) {
                return null; // or throw new EJBException("Car not found");
            }

            return new CarDto(
                    car.getId(),
                    car.getLicensePlate(),
                    car.getParkingSpot(),
                    car.getOwner().getUsername()
            );
        }
    public void updateCar(Long carId, String licensePlate, String parkingSpot, Long ownerId) {
        try {
            Car car = entityManager.find(Car.class, carId);
            if (car == null) {
                throw new EJBException("Car not found with id: " + carId);
            }

            User owner = entityManager.find(User.class, ownerId);
            if (owner == null) {
                throw new EJBException("User not found with id: " + ownerId);
            }

            // Update fields
            car.setLicensePlate(licensePlate);
            car.setParkingSpot(parkingSpot);
            car.setOwner(owner);

            // entityManager.merge(car); <-- NOT needed because the entity is already managed

        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    public void deleteCarsByIds(Collection<Long> carIds) {
        for (Long carId : carIds) {
            Car car = entityManager.find(Car.class, carId);
            entityManager.remove(car);
        }
    }

}





