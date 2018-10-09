package sut.sa.g21;
import java.util.stream.Stream;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sut.sa.g21.entity.User;
import sut.sa.g21.entity.Product;
import sut.sa.g21.entity.Preorder;
import sut.sa.g21.entity.StatusPreorder;
import sut.sa.g21.entity.Province;
import sut.sa.g21.repository.UserRepository;
import sut.sa.g21.repository.ProductRepository;
import sut.sa.g21.repository.PreorderRepository;
import sut.sa.g21.repository.StatusPreorderRepository;
import sut.sa.g21.repository.ProvinceRepository;
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
    ApplicationRunner init(UserRepository userRepository, ProductRepository productRepository, PreorderRepository preorderRepository, StatusPreorderRepository statusPreorderRepository,ProvinceRepository provinceRepository) {
		return args -> {
			
			Stream.of("พึ่งสั่งสินค้า","รอชำระเงิน","จ่ายแล้ว").forEach(statusName -> { 
                statusPreorderRepository.save(new StatusPreorder(statusName));
            });
			statusPreorderRepository.findAll().forEach(System.out::println);

			
			Stream.of("กระบี่","กรุงเทพมหานคร","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร","ขอนแก่น","จันทบุรี","ฉะเชิงเทรา" ,"ชลบุรี","ชัยนาท","ชัยภูมิ","ชุมพร","เชียงราย","เชียงใหม่","ตรัง","ตราด","ตาก","นครนายก","นครปฐม","นครพนม","นครราชสีมา" ,"นครศรีธรรมราช","นครสวรรค์","นนทบุรี","นราธิวาส","น่าน","บุรีรัมย์","ปทุมธานี","ประจวบคีรีขันธ์","ปราจีนบุรี","ปัตตานี" ,"พะเยา","พังงา","พัทลุง","พิจิตร","พิษณุโลก","เพชรบุรี","เพชรบูรณ์","แพร่","ภูเก็ต","มหาสารคาม","มุกดาหาร","แม่ฮ่องสอน" ,"ยโสธร","ยะลา","ร้อยเอ็ด","ระนอง","ระยอง","ราชบุรี","ลพบุรี","ลำปาง","ลำพูน","เลย","ศรีสะเกษ","สกลนคร","สงขลา" ,"สตูล","สมุทรปราการ","สมุทรสงคราม","สมุทรสาคร","สระแก้ว","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรณบุรี","สุราษฎร์ธานี" ,"สุรินทร์","หนองคาย","หนองบัวลำภู","อยุธยา","อ่างทอง","อำนาจเจริญ","อุดรธานี","อุตรดิตถ์","อุทัยธานี","อุบลราชธานี").forEach(provinceName -> { 
                provinceRepository.save(new Province(provinceName));
            });
			provinceRepository.findAll().forEach(System.out::println);
			
			//userRepository.save(new User("yoyo","147 ถ.กกก ต.ในเมือง อ.เมือง",1,"yoyo@hotmail.com",09994596341));
		};
		
	}
}