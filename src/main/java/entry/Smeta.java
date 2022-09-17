package entry;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.File;

@XmlType(name = "Smeta")
@XmlRootElement
public class Smeta {

    File fileSource = null;

    public int lengthFromHomeToSeptik;
    public int priceFromHomeToSeptik;

    public int lengthFromSeptikToTrench;
    public int priceFromSeptikToTrench;

    public int lengthAirDuct;
    public int priceAirDuct;

    public int lengthElectricCable;
    public int priceElectricCable;

    public int totalCosts;
}
