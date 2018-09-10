package URI.Trying.NOSTATUS.AD_HOC;


public class NumberToBath {

    public static String execute(double number) {
        String result = "";
        boolean hasTenDigit = false;
        boolean hasDotTen = false;
        try {
            if (number >= 100) {
                char firstDigit = (number + "").charAt(0);
                switch (firstDigit) {
                    case '1':
                        result += "หนึ่งร้อย";
                        number -= 100;
                        break;
                    case '2':
                        result += "สองร้อย";
                        number -= 200;
                        break;
                    case '3':
                        result += "สามร้อย";
                        number -= 300;
                        break;
                    case '4':
                        result += "สี่ร้อย";
                        number -= 300;
                        break;
                    case '5':
                        result += "ห้าร้อย";
                        number -= 300;
                        break;
                    case '6':
                        result += "หกร้อย";
                        number -= 300;
                        break;
                    case '7':
                        result += "เจ็ดร้อย";
                        number -= 300;
                        break;
                    case '8':
                        result += "แปดร้อย";
                        number -= 300;
                        break;

                    case '9':
                        result += "เก้าร้อย";
                        number -= 300;
                        break;
                }
            }

            if (number >= 10) {
                hasTenDigit = true;
                char firstDigit = (number + "").charAt(0);
                switch (firstDigit) {
                    case '1':
                        result += "สิบ";
                        number -= 10;
                        break;
                    case '2':
                        result += "ยี่สิบ";
                        number -= 20;
                        break;
                    case '3':
                        result += "สามสิบ";
                        number -= 30;
                        break;
                    case '4':
                        result += "สี่สิบ";
                        number -= 40;
                        break;
                    case '5':
                        result += "ห้าสิบ";
                        number -= 50;
                        break;
                    case '6':
                        result += "หกสิบ";
                        number -= 60;
                        break;
                    case '7':
                        result += "เจ็ดสิบ";
                        number -= 70;
                        break;
                    case '8':
                        result += "แปดสิบ";
                        number -= 80;
                        break;

                    case '9':
                        result += "เก้าสิบ";
                        number -= 90;
                        break;
                }
            }

            if (number >= 1) {
                char firstDigit = (number + "").charAt(0);
                switch (firstDigit) {
                    case '1':
                        result += (hasTenDigit ? "เอ็ด" : "หนึ่ง");
                        number -= 1;
                        break;
                    case '2':
                        result += "สอง";
                        number -= 2;
                        break;
                    case '3':
                        result += "สาม";
                        number -= 3;
                        break;
                    case '4':
                        result += "สี่";
                        number -= 4;
                        break;
                    case '5':
                        result += "ห้า";
                        number -= 5;
                        break;
                    case '6':
                        result += "หก";
                        number -= 6;
                        break;
                    case '7':
                        result += "เจ็ด";
                        number -= 7;
                        break;
                    case '8':
                        result += "แปด";
                        number -= 8;
                        break;

                    case '9':
                        result += "เก้า";
                        number -= 9;
                        break;
                }
            }

            result += "บาท";

            if (number >= 0.01) {

                if (number >= 0.1) {
                    number *= 10;
                    char firstDigit = (number + "").charAt(0);
                    hasDotTen = true;
                    switch (firstDigit) {
                        case '1':
                            result += "สิบ";
                            number -= 1;
                            break;
                        case '2':
                            result += "ยี่สิบ";
                            number -= 2;
                            break;
                        case '3':
                            result += "สามสิบ";
                            number -= 3;
                            break;
                        case '4':
                            result += "สี่สิบ";
                            number -= 4;
                            break;
                        case '5':
                            result += "ห้าสิบ";
                            number -= 5;
                            break;
                        case '6':
                            result += "หกสิบ";
                            number -= 6;
                            break;
                        case '7':
                            result += "เจ็ดสิบ";
                            number -= 7;
                            break;
                        case '8':
                            result += "แปดสิบ";
                            number -= 8;
                            break;
                        case '9':
                            result += "เก้าสิบ";
                            number -= 9;
                            break;
                    }
                }

                if (number >= 0.1) {
                    number *= 10;
                    char firstDigit = (number + "").charAt(0);
                    switch (firstDigit) {
                        case '1':
                            result += (hasDotTen ? "เอ็ด" : "หนึ่ง");
                            number -= 1;
                            break;
                        case '2':
                            result += "สอง";
                            number -= 2;
                            break;
                        case '3':
                            result += "สาม";
                            number -= 3;
                            break;
                        case '4':
                            result += "สี่";
                            number -= 4;
                            break;
                        case '5':
                            result += "ห้า";
                            number -= 5;
                            break;
                        case '6':
                            result += "หก";
                            number -= 6;
                            break;
                        case '7':
                            result += "เจ็ด";
                            number -= 7;
                            break;
                        case '8':
                            result += "แปด";
                            number -= 8;
                            break;
                        case '9':
                            result += "เก้า";
                            number -= 9;
                            break;
                    }
                }
                result += "สตางค์";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(execute(123.34));
    }
}
