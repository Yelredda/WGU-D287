<strong> Yelredda <br>
D287 - Java Frameworks <br>
Practical Assessment <br>
README.md - Used to track changes made to template project, including: prompt, file name, line number, and change.  
</strong>

<strong>
<br>
<br>
C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
</strong>

<pre>

    CHANGE - mainscreen.html
        Line 14 - &lt title &gt My Bicycle Shop &lt title &gt
        TO
        Line 14 - &lt title &gt Yelredda's Computer Supply Store &lt /title &gt
        
        Line 19 - &lt h1 &gt Shop &lt /h1 &gt
        TO
        Line 19 - &lt h1 &gt Shop for computer supplies  &lt /h1 &gt
</pre>

<strong>
<br>
<br>
D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
</strong>

<pre>

    CREATE - about.html

        &lt !DOCTYPE html &gt  
        &lt html lang="en" &gt  
        &lt head &gt  
            &lt meta charset="UTF-8" &gt  
            &lt title &gt  About Us&lt /title &gt  
        &lt /head &gt  
        &lt body &gt  
        
            &lt p &gt  
            Yelredda's Computer Supply Store is your one-stop shop for computers and computer accessories. Profits don't matter,
                so you'll never find a better deal. Guaranteed or your money back.
        
            &lt /p &gt  
        
            &lt a href="http://localhost:8080/" &gt  Link to Main Screen&lt /a &gt  
        &lt /body &gt  
        &lt /html &gt  

    INSERT - mainscreen.html
    
        Line 95 - &lt a th:href="@{about}" &gt About us... &lt /a &gt

    INSERT - MainScreenControllerr, LINES 57-61

        @RequestMapping("/about")
        public String about() {
            return "about"; // about.html page reference
        }

</pre>

<strong>
<br>
<br>
E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part

</strong>

<pre>

    INSERT - BootStrapData.java, LINES 71-162

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

</pre>

<strong>
<br>
<br>
F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:

•   The “Buy Now” button must be next to the buttons that update and delete products.

•   The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.

•   Display a message that indicates the success or failure of a purchase.

</strong>

<pre>

    CREATE - confirmationbuyproduct.html

        &lt !DOCTYPE html &gt 
        &lt html lang="en" &gt 
        &lt head &gt 
            &lt meta charset="UTF-8" &gt 
            &lt title &gt Product Purchase Confirmation &lt /title &gt 
        &lt /head &gt 
        &lt body &gt 
        &lt h1 &gt Your product has been purchased. &lt /h1 &gt 
        
        &lt a href="http://localhost:8080/" &gt Link to Main Screen &lt /a &gt 
        &lt /body &gt 
        &lt /html &gt 

    CREATE - errorbuyproduct.html

         &lt !DOCTYPE html &gt 
         &lt html lang="en" &gt 
         &lt head &gt 
             &lt meta charset="UTF-8" &gt 
             &lt title &gt Error purchasing product. &lt /title &gt 
         &lt /head &gt 
         &lt body &gt 
         &lt h1 &gt Error purchasing product. Confirm current inventory. &lt /h1 &gt 
        
         &lt a href="http://localhost:8080/" &gt Link to Main Screen &lt /a &gt 
        
         &lt /body &gt 
         &lt /html &gt 

    INSERT - mainscreen.html, LINES 89-90

        &lt a th:href="@{/buyproduct(productID=${tempProduct.id})}" class="btn btn-primary btn-sm mb-3"
        onclick="if(!(confirm('Are you sure you want to purchase this product?')))return false" &gt Buy Now &lt /a &gt 
    
    INSERT - product.java, LINES 108-118

        // Instruction F: buyProduct function to decrement inventory
        // Uses a simple test to ensure product exists before decrementing
        public boolean buyProduct() {
            if (this.inv >= 1 ) {
                this.inv--;
                return true;
            } else {
                return false;
            }
        
        }

    INSERT - AddProductController.java

        LINE 172 - @GetMapping("/buyproduct")
        LINE 173 - public String buyProduct(@RequestParam("productID") int theId, Model theModel ) {
        LINE 174 - ProductService productService = context.getBean(ProductServiceImpl.class);
        LINE 175 - Product product2 = productService.findById(theId);
        LINE 176 - 
        LINE 177 - boolean purchaseConfirmation = product2.buyProduct();
        LINE 178 - if ( purchaseConfirmation ) {
        LINE 179 -     productService.save(product2);
        LINE 180 -     return "confirmationbuyproduct";
        LINE 181 - }
        LINE 182 - 
        LINE 183 - return "errorbuyproduct";
        LINE 184 - }

</pre>

<strong>
<br>
<br>
G. Modify the parts to track maximum and minimum inventory by doing the following:

•   Add additional fields to the part entity for maximum and minimum inventory.
</strong>

<pre>

    INSERT - mainscreen.html, LINES 38-39 AND LINES 48-49
        &lt th &gt Minimum &lt /th &gt 
        &lt th &gt Maximum &lt /th &gt 

        &lt td th:text="${tempPart.minimum}" &gt 1 &lt /td &gt 
        &lt td th:text="${tempPart.maximum}" &gt 1 &lt /td &gt

</pre>

<strong>
•   Modify the sample inventory to include the maximum and minimum fields.
</strong>

<pre>

    INSERT - Part.java, LINES 36-38 AND LINES 113-117
        @Min (value = 0, message = "Minimum inventory must be > 0")
        int minimum;
        int maximum;

        public void setMinimum(int minimum) { this.minimum = minimum; }
        public int getMinimum() { return this.minimum; }
         
        public void setMaximum(int maximum) { this.maximum = maximum; }
        public int getMaximum() { return this.maximum; }

    NOTE: Added default min/max (0/100 respectively) to default constructors
    for both in house and outsource parts

    INSERT - InhousePart.java AND OutsourcedPart.java, LINES 18-20
        // Adding default values for maximum and minimum; can be changed in app
        this.minimum = 0;
        this.maximum = 100;

</pre>

<strong>
•   Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
</strong> 

<pre>

    INSERT - InhousePartForm.html AND OutsourcedPartForm.html, LINES 25-35

        &lt p &gt  &lt input type="text" th:field="*{minimum}" placeholder="Minimum" class="form-control mb-4 col-4"/ &gt  &lt /p &gt 
             
        &lt p &gt  &lt input type="text" th:field="*{maximum}" placeholder="Maximum" class="form-control mb-4 col-4"/ &gt  &lt /p &gt 
             
        &lt p &gt  &lt input type="text" th:field="*{partId}" placeholder="Part ID" class="form-control mb-4 col-4"/ &gt  &lt /p &gt 
    
        &lt p &gt 
        &lt div th:if="${#fields.hasAnyErrors()}" &gt 
            &lt ul &gt  &lt li th:each="err: ${#fields.allErrors()}" th:text="${err}" &gt  &lt /li &gt  &lt /ul &gt 
        &lt /div &gt 
        &lt /p &gt 

</pre>

<strong>
•   Rename the file the persistent storage is saved to.
</strong>

<pre>

    CHANGE - application.properties
        spring.datasource.url=jdbc:h2:file:~/spring-boot-h2-db102
        TO
        spring.datasource.url=jdbc:h2:file:~/src/main/resources/spring-boot-h2-db102

</pre>

<strong>
•   Modify the code to enforce that the inventory is between or at the minimum and maximum value.
</strong>

<pre>

NOTE: This requirement is enforced from a code standpoint by a validateLimits() function that is called
by the save() function just before saving the part changes to the repository. If the value is
outside of the threshold (e.g. below the minimum or above the maximum) then inv is forcibly set
to the corresponding limit.

    INSERT - Part.java LINES 97-103
        public void validateLimits() {
            if (this.inv < this.minimum) {
                this.inv = this.minimum;
            } else if (this.inv > this.maximum ) {
                this.inv = this.maximum;
            }
        }

    INSERT - InhousePartServiceImpl.java AND OutsourcedPartServiceImpl.java, LINE 54... save()
        thePart.validateLimits();

NOTE: there are also validators in place to prevent the form from accepting a value for inventory
that is below the minimum or above the maximum, outlined in section H. 

</pre>


<strong>
<br>
<br>
H. Add validation for between or at the maximum and minimum fields. The validation must include the following:
</strong>

<pre>

    INSERT - Part.java, LINES 21-22
        @ValidPartInventory
        @ValidPartInventoryMinimum

</pre>

<strong>
•   Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
</strong>

<pre>

    CREATE - PartInventoryMinimumValidator.java

        package com.example.demo.validators;
        
        import com.example.demo.domain.Part;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.ApplicationContext;
        
        import javax.validation.ConstraintValidator;
        import javax.validation.ConstraintValidatorContext;
        
        /**
         *
         *
         *
         *
         */
        public class PartInventoryMinimumValidator implements ConstraintValidator &lt ValidPartInventoryMinimum, Part &gt {
            @Autowired
            private ApplicationContext context;
        
            public static  ApplicationContext myContext;
        
            @Override
            public void initialize(ValidPartInventoryMinimum constraintAnnotation) {
                ConstraintValidator.super.initialize(constraintAnnotation);
            }
        
            @Override
            public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
                return part.getInv() > part.getMinimum();
            }
        }

    CREATE ValidPartInventoryMinimum.java

        package com.example.demo.validators;
        
        import javax.validation.Constraint;
        import javax.validation.Payload;
        import java.lang.annotation.ElementType;
        import java.lang.annotation.Retention;
        import java.lang.annotation.RetentionPolicy;
        import java.lang.annotation.Target;
        
        /**
         *
         *
         *
         *
         */
        @Constraint(validatedBy = {PartInventoryMinimumValidator.class})
        @Target({ElementType.TYPE})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ValidPartInventoryMinimum {
            String message() default "Inventory cannot be lower than required minimum";
            Class<?> [] groups() default {};
            Class<? extends Payload> [] payload() default {};
        }

</pre>

<strong>
•   Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
</strong>

<pre>

NOTE: There isn't a validator here because the requirements of section F is that the "Buy Now" button doesn't change the 
inventory of the associated parts. 

If I were to implement this feature, I would have needed to modify the buyProduct() 
function that I created to decrement the inventory of the parts as well like so:

    public boolean buyProduct() {
        if (this.inv >= 1 ) {
            this.inv--;

            for(Part part:this.getParts()){
                if (part.getInv() >= 1) {
                    part.setInv(part.getInv() - 1);
                } else {
                    return false;
                }
            }
    }

Then, I could have modified the errorbuypart.html to include the validation error that
would have been triggered by PartInventoryMinimumValidator.

</pre>

<strong>
•   Display error messages when adding and updating parts if the inventory is greater than the maximum.
</strong>

<pre>

    CREATE - PartInventoryValidator.java

        package com.example.demo.validators;
        
        import com.example.demo.domain.Part;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.ApplicationContext;
        
        import javax.validation.ConstraintValidator;
        import javax.validation.ConstraintValidatorContext;
        
        /**
         *
         *
         *
         *
         */
        public class PartInventoryValidator implements ConstraintValidator &lt ValidPartInventory, Part &gt {
            @Autowired
            private ApplicationContext context;
        
            public static  ApplicationContext myContext;
        
            @Override
            public void initialize(ValidPartInventory constraintAnnotation) {
                ConstraintValidator.super.initialize(constraintAnnotation);
            }
        
            @Override
            public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
                return part.getInv() <= part.getMaximum();
            }
        }

    CREATE - ValidPartInventory.java

        package com.example.demo.validators;
        
        import javax.validation.Constraint;
        import javax.validation.Payload;
        import java.lang.annotation.ElementType;
        import java.lang.annotation.Retention;
        import java.lang.annotation.RetentionPolicy;
        import java.lang.annotation.Target;
        
        /**
         *
         *
         *
         *
         */
        @Constraint(validatedBy = {PartInventoryValidator.class})
        @Target({ElementType.TYPE})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ValidPartInventory {
            String message() default "Inventory cannot exceed maximum value";
            Class<?> [] groups() default {};
            Class<? extends Payload> [] payload() default {};
        }

</pre>

<strong>
<br>
<br>
I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

</strong>

<pre>

    INSERT - PartTest.java, LINES 160-176
        @Test
        void getMinimum() {
            int minimum=5;
            partIn.setMinimum(minimum);
            assertEquals(minimum, partIn.getMinimum());
            partOut.setMinimum(minimum);
            assertEquals(minimum, partOut.getMinimum());
        }
    
        @Test
        void getMaximum() {
            int maximum=5;
            partIn.setMaximum(maximum);
            assertEquals(maximum, partIn.getMaximum());
            partOut.setMaximum(maximum);
            assertEquals(maximum, partOut.getMaximum());
        }
</pre>

<strong>
<br>
<br>
J.  Remove the class files for any unused validators in order to clean your code.
</strong>

<pre>

Unused validators review:
    ValidDeletePart (DeletePartValidator) - Used in Part.java 
        Prevents parts from being deleted if they're associated with a product

    ValidEnufParts (EnufPartsValidator) - Used in Product.java
        Prevents adding additional product inventory if there isn't enough associated parts inventory

    ValidPartInventory (PartInventoryValidator) - Used in Part.java
        Prevents adding additional part inventory if it exceeds the specified max

    ValidPartInventoryMinimum (PartInventoryMinimumValidator) - Used in Part.java
        Prevents modifying part inventory if it the changes puts it below the min threshold

    ValidProductPrice (PriceProductValidator) - Used in Product.java
        Prevents charging less for the product than the sum cost of its associated parts

All 5 validators in the project are being used. 

</pre>


