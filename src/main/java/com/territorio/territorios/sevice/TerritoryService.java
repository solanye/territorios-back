package com.territorio.territorios.sevice;

import com.territorio.territorios.dto.TerritoryDTO;
import com.territorio.territorios.mapper.TerritoryMapper;
import com.territorio.territorios.repository.TerritoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TerritoryService {
    private final TerritoryRepository territoryRepository;
    private final TerritoryMapper territoryMapper;

    public TerritoryDTO create(TerritoryDTO dto){
        return territoryMapper.toDto(territoryRepository.save(territoryMapper.toEntity(dto)));
    }
    public TerritoryDTO getById(Integer id){
        return territoryRepository.findById(id)
                .map(territoryMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Territory not found"));
    }
    public List<TerritoryDTO> getAll(){
        return territoryRepository.findAllByDeletedAtIsNull()
                .stream()
                .map(territoryMapper::toDto)
                .toList();
    }
    public void delete(Integer id){
        territoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Territory not found"))
                .setDeletedAt(java.time.LocalDate.now());
    }
}
