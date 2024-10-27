import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        try { //memanggil fungsi validatepassword 
            validatePassword(password); // validatepassword menerima string validadate password sesuai kriteria yang ditentukan
            System.out.println("Password valid.");
        } catch  //catch dieksekusi jika terjadi pengecualian dari (invalidatepassword)
        (InvalidPasswordException e){ // invalidpassword = menandai password jika tidak valid
            System.out.println("Password tidak valid: " + e.getMessage()); //menampilkan pesan invalid, beserta keslahan yang berasal dari objek (e.getMessage)
        }
    }

    // validasi password harus 8 karakter
    public static void validatePassword(String password) throws InvalidPasswordException {//mendeklarasikan fungsi validatepassword, yang menerima string password dan dapat melempar exception invalidpasword
        if (password.length() < 8) { // melakukan pengecekan panjang minimal 8 kar
            throw new InvalidPasswordException("Password harus minimal 8 karakter.");// jika pass tidak 8 kar akan dilempar ke invalidpass
        }

        //boolean mengambil keputusan/ identifikasi true dan false
        boolean hasUpperCase = false; //penanda password tersbt belum mengandung huruf besar
        boolean hasLowerCase = false; 
        boolean hasDigit = false; 
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) { // melakukan perulangan terhadap setiap karakter (c)
            if (Character.isUpperCase(c)) { //mengecek apakah kar c huruf besar
                hasUpperCase = true; //jika iya kar c akan dirubah menjadi true
            } else if (Character.isLowerCase(c)) {//mengecek apakah kar c huruf kecil
                hasLowerCase = true; //jika iya kar c akan dirubah menjadi true
            } else if (Character.isDigit(c)) {//mengecek apakah kar c huruf angka
                hasDigit = true; //jika iya kar c akan dirubah menjadi true
            } else if ("!@#$%^&*".contains(String.valueOf(c))) {//mengecek apakah kar c karakter khusus
                hasSpecialChar = true;
            }
        }

        if (!hasUpperCase) {
            throw new InvalidPasswordException("Password harus mengandung setidaknya satu huruf besar.");
        }
        if (!hasLowerCase) {
            throw new InvalidPasswordException("Password harus mengandung setidaknya satu huruf kecil.");
        }
        if (!hasDigit) {
            throw new InvalidPasswordException("Password harus mengandung setidaknya satu angka.");
        }
        if (!hasSpecialChar) {
            throw new InvalidPasswordException("Password harus mengandung setidaknya satu karakter khusus (!@#$%^&*).");
        }
    }
}

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}