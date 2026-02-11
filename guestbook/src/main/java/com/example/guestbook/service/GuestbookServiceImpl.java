package com.example.guestbook.service;

import com.example.guestbook.entity.Guestbook;
import com.example.guestbook.repository.GuestbookRepository;
import com.example.guestbook.dto.GuestbookDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService{
    private final GuestbookRepository repository;

    @Override
    public Long register(GuestbookDTO dto){
        Guestbook entity = dtoToEntity(dto);
        repository.save(entity);
        return entity.getGno();
    }
    @Override
    public List<GuestbookDTO> getList() {
        List<Guestbook> result = repository.findAll(Sort.by(Sort.Direction.DESC, "gno"));

        return result.stream()
                .map(entity -> entityToDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public GuestbookDTO read(Long gno) {
        Optional<Guestbook> result = repository.findById(gno);
        return result.isPresent() ? entityToDto(result.get()) : null;
    }

}
