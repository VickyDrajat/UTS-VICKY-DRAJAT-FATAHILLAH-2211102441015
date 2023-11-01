import greenfoot.*;
import java.util.List;
public class Snake extends Actor

{
        private int speed = 1; // Kecepatan pergerakan ular
        private int length = 1; // Panjang awal ular
        private int delay = 10; // Delay antar gerakan
        private int counter = 0; // Counter untuk delay
        private int[] xCoords = new int[100]; // Array untuk menyimpan koordinat x
        private int[] yCoords = new int[100]; // Array untuk menyimpan koordinat y
        private int direction = 0; // Arah awal ular (0 = ke kanan, 1 = ke atas, 2 = ke kiri, 3 = ke bawah)
    public Snake()
    {
// Set gambar ular (pastikan Anda sudah menambahkan gambar ular ke Greenfoot) setImage("snake.png");
        // Inisialisasi koordinat awal
        xCoords[0] = getX();
        yCoords[0] = getY();
}
    public void act()
    {
        // Pergerakan ular
        if (counter == delay) {
            move(speed);
            counter = 0;
            // Simpan koordinat baru
            xCoords[0] = getX();
            yCoords[0] = getY();
            // Pergerakan tubuh ular
            moveBody();
// Perubahan arah berdasarkan input pengguna checkKeyPress();
            // Memeriksa tumbukan dengan tepi layar
            checkEdgeCollision();
        } else {
counter++; }
}
    public void moveBody()
    {
// Memindahkan tubuh ular mengikuti kepala for (int i = length - 1; i > 0; i--) {
            xCoords[i] = xCoords[i - 1];
            yCoords[i] = yCoords[i - 1];
        }
}
    public void checkKeyPress()
    {
// Mengubah arah berdasarkan input pengguna
if (Greenfoot.isKeyDown("right") && direction != 2) {
            direction = 0;
        }
if (Greenfoot.isKeyDown("up") && direction != 3) { direction = 1;
}
if (Greenfoot.isKeyDown("left") && direction != 0) {
            direction = 2;
        }
if (Greenfoot.isKeyDown("down") && direction != 1) { direction = 3;
} }
    public void checkEdgeCollision()
    {
if (getX() <= 0 || getX() >= getWorld().getWidth() - 1 || getY() <= 0 || getY() >= getWorld().getHeight() - 1) { Greenfoot.stop();
} }

public boolean hitWall()
    {
if (getX() <= 0 || getX() >= getWorld().getWidth() - 1 || getY() <= 0 || getY() >= getWorld().getHeight() - 1) { return true;
}
        return false;
    }
    public boolean hitItself()
    {
for (int i = 1; i < length; i++) {
if (getX() == xCoords[i] && getY() == yCoords[i]) {
                return true;
            }
}
        return false;
    }
    public void extend()
    {
length++;
xCoords[length - 1] = xCoords[length - 2];
yCoords[length - 1] = yCoords[length - 2];
getWorld().addObject(new Tail(), xCoords[length - 1], yCoords[length