package com.example.video_slicing_tool;

import com.example.video_slicing_tool.Controller.SlicerController;
import com.example.video_slicing_tool.model.VideoSlice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class VideoSlicingToolApplication {
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(VideoSlicingToolApplication.class, args);
		Scanner sc = new Scanner(System.in);
		System.out.println("Java is running from: " + System.getProperty("user.dir") + "\n");

		System.out.println("Hello! Please enter original video name: ");
		String originalVideoName = sc.nextLine();

		List<VideoSlice> slices = new ArrayList<>();
		System.out.println("Please enter how many slices you want to create: ");
		int sliceQuantity = sc.nextInt();
		sc.nextLine();

		System.out.println("Slice Interval Format -> hh:mm:ss (00:00:00)");
		int sliceNumber = 1;
		while (sliceNumber < (sliceQuantity + 1)) {
			System.out.println("Please enter #" + sliceNumber + " slice: ");
			VideoSlice slice = new VideoSlice();

			System.out.println("Please enter start of the slice: ");
			String startOfSlice = sc.nextLine();
			slice.setSliceBeginning(startOfSlice);

			System.out.println("Please enter end of the slice: ");
			String endOfSlice = sc.nextLine();
			slice.setSliceEnd(endOfSlice);

			slices.add(slice);
			sliceQuantity--;
		}

		System.out.println("Please select slicing mode (enter #):\n:");
		System.out.println("1. Quick (fast, rough cut)");
		System.out.println("2. Balanced (fast & precise – default)");
		System.out.println("3. Accurate (slower, most precise)");
		int slicingMode = sc.nextInt();

		System.out.println("Please enter how would you like to name file/files: ");
		String outputFileName = sc.nextLine();

		SlicerController slicerController = new SlicerController();
		if (slices.size() == 1) {
			slicerController.singleSlice(originalVideoName, slices.get(0), slicingMode, outputFileName);
		} else if (slices.size() > 1) {
			slicerController.manySlices(originalVideoName, slices, slicingMode, outputFileName);
		}
	}
}