package com.territorio.territorios.sevice;

import com.territorio.territorios.dto.LogDTO;
import com.territorio.territorios.mapper.LogMapper;
import com.territorio.territorios.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;
    private final LogMapper logMapper;

    public LogDTO create(LogDTO dto) {
        return logMapper.toDto(logRepository.save(logMapper.toEntity(dto)));
    }
    public LogDTO getById(Integer id) {
        return logRepository.findById(id)
                .map(logMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Log not found"));
    }
    public List<LogDTO> getAll() {
        return logRepository.findAllByDeletedAtIsNull()
                .stream()
                .map(logMapper::toDto)
                .toList();
    }
    public List<LogDTO> getAllByLocationId(Integer locationId) {
        return logRepository.findByLocationIdAndDeletedAtIsNull(locationId)
                .stream()
                .map(logMapper::toDto)
                .toList();
    }
    public void delete(Integer id) {
        logRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Log not found"))
                .setDeletedAt(java.time.LocalDate.now());
    }
}
