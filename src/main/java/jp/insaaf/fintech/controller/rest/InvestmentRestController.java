package jp.insaaf.fintech.controller.rest;

import jp.insaaf.fintech.data.entity.Investment;
import jp.insaaf.fintech.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/investments")
public class InvestmentRestController {

    @Autowired
    private InvestmentService investmentService;

    @GetMapping
    public List<Investment> getAllInvestments() {
        return investmentService.getAllInvestments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investment> getInvestmentById(@PathVariable("id") String id) {
        Optional<Investment> investment = investmentService.getInvestmentById(id);
        return investment.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createInvestment(@RequestBody Investment investment) {
        try {
            Investment createdInvestment = investmentService.createInvestment(investment);
            return ResponseEntity.created(URI.create("/investments/" + createdInvestment.getId()))
                    .body(createdInvestment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Investment> updateInvestment(@PathVariable("id") String id, @RequestBody Investment investment) {
        investment.setId(id);
        Investment updatedInvestment = investmentService.updateInvestment(investment);
        return ResponseEntity.ok(updatedInvestment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvestment(@PathVariable("id") String id) {
        investmentService.deleteInvestmentById(id);
        return ResponseEntity.noContent().build();
    }
}
