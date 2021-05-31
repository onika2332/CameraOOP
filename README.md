Add georegression library for your project.

	1. Search https://sourceforge.net/projects/georegression/
	2. Choose the latest version of JAR file with compressed in .zip (e.x. Released /0.23/georegression-v0.23-libs.zip )
	3. After completely download, extract the .zip
	4. Open your Eclipse, choose project, right-click
	5. Choose Build path -> Add external achives...
	6. Choo directory of all JAR file in your folder you've extract, click OK
Nam : T đã thêm những chức năng sau cho camera:
	- Check camera có hợp lệ( nằm trong phòng hay trên tường không) : public boolean checkCameraOnPlane()
	- Đưa ra tập 4 điểm là 4 góc của hình vuông, là hình chiếu của camera lên tường đối diện ( p0, p1, p2, p3 , O : hình chiếu của camera lên tường đối diện)
		p1-----|------p2
		|      |      |
		|------O------|                   : public List<Point> getShadow()
		|      |      |
		p0-----|------p3
	- Check 1 điểm bất kì có nằm trong tầm nhìn của camera hay không? : public boolean checkPointInRange()
	- Mong muốn class Room của Đạt + Linh cung cấp các thuộc tính sau :
		+ ) List<Plane> walls: với các input vào, lập ra list các mặt phẳng chứa các mặt của hình hộp
		+) 3 thuộc tính length, width, height tương ứng với 3 giá trị chiều dài(theo trục Ox), chiều rộng(theo trục Oy), chiều cao(theo trục Oz)
