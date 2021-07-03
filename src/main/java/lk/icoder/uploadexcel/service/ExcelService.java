package lk.icoder.uploadexcel.service;

import lk.icoder.uploadexcel.entity.Adjustment;
import lk.icoder.uploadexcel.entity.Tutorial;
import lk.icoder.uploadexcel.helper.ExcelHelper;
import lk.icoder.uploadexcel.repository.AdjustmentRepository;
import lk.icoder.uploadexcel.repository.TutorialRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

  private TutorialRepository repository;
  private AdjustmentRepository adjustmentRepository;

  public ExcelService(TutorialRepository repository, AdjustmentRepository adjustmentRepository) {
    this.repository = repository;
    this.adjustmentRepository = adjustmentRepository;
  }

  public void save(MultipartFile file) {
    try {
      List<Adjustment> adjustmentList = ExcelHelper.excelToTutorials(file.getInputStream());
      adjustmentRepository.saveAll(adjustmentList);
    } catch (IOException e) {
      throw new RuntimeException("fail to store excel data: " + e.getMessage());
    }
  }

  public ByteArrayInputStream load() {
    List<Tutorial> tutorials = repository.findAll();

    ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(tutorials);
    return in;
  }

  public List<Tutorial> getAllTutorials() {
    return repository.findAll();
  }
}
