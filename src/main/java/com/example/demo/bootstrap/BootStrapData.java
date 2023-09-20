package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        // Clearing repositories for multiple test runs
        // partRepository.deleteAll();
        // productRepository.deleteAll();
        // outsourcedPartRepository.deleteAll();

        if (partRepository.count() == 0) {

            InhousePart ram100 = new InhousePart();
            ram100.setName("RAM100");
            ram100.setPrice(19.99);
            ram100.setInv(10);

            InhousePart ram200 = new InhousePart();
            ram200.setName("RAM200");
            ram200.setPrice(29.99);
            ram200.setInv(10);

            InhousePart ram300 = new InhousePart();
            ram300.setName("RAM300");
            ram300.setPrice(39.99);
            ram300.setInv(10);

            InhousePart ram400 = new InhousePart();
            ram400.setName("RAM400");
            ram400.setPrice(49.99);
            ram400.setInv(10);

            InhousePart ram500 = new InhousePart();
            ram500.setName("RAM500");
            ram500.setPrice(59.99);
            ram500.setInv(10);

            partRepository.save(ram100);
            partRepository.save(ram200);
            partRepository.save(ram300);
            partRepository.save(ram400);
            partRepository.save(ram500);
        }

        if (outsourcedPartRepository.count() == 0) {

            OutsourcedPart ssd1000 = new OutsourcedPart();
            ssd1000.setName("ssd1000");
            ssd1000.setPrice(19.99);
            ssd1000.setInv(10);
            ssd1000.setCompanyName("TheoCorp");

            OutsourcedPart ssd2000 = new OutsourcedPart();
            ssd2000.setName("ssd2000");
            ssd2000.setPrice(29.99);
            ssd2000.setInv(10);
            ssd2000.setCompanyName("TheoCorp");

            OutsourcedPart ssd3000 = new OutsourcedPart();
            ssd3000.setName("ssd3000");
            ssd3000.setPrice(39.99);
            ssd3000.setInv(10);
            ssd3000.setCompanyName("TheoCorp");

            OutsourcedPart ssd4000 = new OutsourcedPart();
            ssd4000.setName("ssd4000");
            ssd4000.setPrice(49.99);
            ssd4000.setInv(10);
            ssd4000.setCompanyName("TheoCorp");

            OutsourcedPart ssd5000 = new OutsourcedPart();
            ssd5000.setName("ssd5000");
            ssd5000.setPrice(59.99);
            ssd5000.setInv(10);
            ssd5000.setCompanyName("TheoCorp");

            outsourcedPartRepository.save(ssd1000);
            outsourcedPartRepository.save(ssd2000);
            outsourcedPartRepository.save(ssd3000);
            outsourcedPartRepository.save(ssd4000);
            outsourcedPartRepository.save(ssd5000);
        }

        if (productRepository.count() == 0 ) {

            Product r710 = new Product("R710", 199.99, 15);
            Product r720 = new Product("R720", 299.99, 15);
            Product r730 = new Product("R730", 399.99, 15);
            Product r740 = new Product("R740", 499.99, 15);
            Product r750 = new Product("R750", 599.99, 15);

            productRepository.save(r710);
            productRepository.save(r720);
            productRepository.save(r730);
            productRepository.save(r740);
            productRepository.save(r750);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
