package com.territorio.territorios.sevice;

import com.territorio.territorios.dto.LocationDTO;
import com.territorio.territorios.mapper.LocationMapper;
import com.territorio.territorios.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public LocationDTO create(LocationDTO dto) {
        return locationMapper.toDto(locationRepository.save(locationMapper.toEntity(dto)));
    }
    public LocationDTO getById(Integer id) {
        return locationRepository.findById(id)
                .map(locationMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Location not found"));
    }
    public List<LocationDTO> getAll() {
        return locationRepository.findAllByDeletedAtIsNull()
                .stream()
                .map(locationMapper::toDto)
                .toList();
    }
    public List<LocationDTO> getAllByTerritoryId(Integer territoryId) {
        return locationRepository.findByTerritoryIdAndDeletedAtIsNull(territoryId)
                .stream()
                .map(locationMapper::toDto)
                .toList();
    }
    public void delete(Integer id) {
        locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"))
                .setDeletedAt(java.time.LocalDate.now());
    }
}
