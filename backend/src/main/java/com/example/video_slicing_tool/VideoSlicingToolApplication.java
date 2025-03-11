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

		System.out.println("Java is running from: " + System.getProperty("user.dir"));
		System.out.println("Hello! Please enter original video link/path: ");
		String originalVideoLink = sc.nextLine();

		List<VideoSlice> slices = new ArrayList<>();
		System.out.println("Please enter how many slices you want to create: ");
		int quantity = sc.nextInt();
		sc.nextLine();

		System.out.println("Slice Interval Format -> hh:mm:ss (00:00:00)");
		int count = 1;
		while (quantity > 0/* && count <= quantity*/) {
			System.out.println("Please enter #" + quantity + " slice: ");
			VideoSlice slice = new VideoSlice();

			System.out.println("Please enter start of the slice: ");
			String startSlice = sc.nextLine();
			slice.setSliceBeginning(startSlice);

			System.out.println("Please enter end of the slice: ");
			String endSlice = sc.nextLine();
			slice.setSliceEnd(endSlice);

			slices.add(slice);
			quantity--;
			count++;
		}

		System.out.println("Please enter where you would like to save the slice/slices: ");
		String outputSavePath = sc.nextLine();


		SlicerController slicerController = new SlicerController();
		if (slices.size() == 1) {
			slicerController.sliceVideo(originalVideoLink, slices.get(0), outputSavePath);
		} else if (slices.size() > 1) {
			slicerController.severalSlicesVideo(originalVideoLink, slices, outputSavePath);
		}
	}
}