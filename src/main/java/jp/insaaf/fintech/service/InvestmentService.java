package jp.insaaf.fintech.service;

import jp.insaaf.fintech.data.entity.Investment;
import jp.insaaf.fintech.data.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;

    public List<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }

    public Optional<Investment> getInvestmentById(String id) {
        return investmentRepository.findById(id);
    }

    public Investment createInvestment(Investment investment) {
        return investmentRepository.save(investment);
    }

    public Investment updateInvestment(Investment investment) {
        return investmentRepository.save(investment);
    }

    public void deleteInvestmentById(String id) {
        investmentRepository.deleteById(id);
    }
}
