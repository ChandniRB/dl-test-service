package demo.dl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DLService {
    
    @Autowired
    private DLRepository dlRepository;

    public  DLModel createDL(DLModel dl) {
        return dlRepository.save(dl);
    }

    public Optional<DLModel> getDLById(UUID id) {
        return dlRepository.findById(id);
    }
}
