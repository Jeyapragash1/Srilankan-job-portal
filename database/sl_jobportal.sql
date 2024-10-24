-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 09, 2024 at 04:16 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lk_job`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`, `email`, `created_at`) VALUES
(1, 'admin1', 'adminpass1', 'admin1@jobportal.com', '2024-08-07 19:59:06'),
(2, 'admin2', 'adminpass2', 'admin2@jobportal.com', '2024-08-07 19:59:06'),
(3, 'admin3', 'adminpass3', 'admin3@jobportal.com', '2024-08-07 20:00:25');

-- --------------------------------------------------------

--
-- Table structure for table `applications`
--

CREATE TABLE `applications` (
  `id` int(11) NOT NULL,
  `job_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `application_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `status` enum('applied','interviewed','accepted','rejected') DEFAULT 'applied'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `applications`
--

INSERT INTO `applications` (`id`, `job_id`, `student_id`, `application_date`, `status`) VALUES
(1, 1, 5, '2024-08-07 19:59:54', 'applied'),
(2, 2, 6, '2024-08-07 19:59:54', 'interviewed'),
(3, 1, 7, '2024-08-07 20:01:03', 'accepted'),
(4, 2, 8, '2024-08-07 20:01:03', 'rejected'),
(5, 3, 9, '2024-08-07 20:01:03', 'applied');

-- --------------------------------------------------------

--
-- Table structure for table `employers`
--

CREATE TABLE `employers` (
  `id` int(11) NOT NULL,
  `company_name` varchar(100) DEFAULT NULL,
  `contact_name` varchar(100) DEFAULT NULL,
  `contact_email` varchar(100) DEFAULT NULL,
  `contact_phone` varchar(15) DEFAULT NULL,
  `address` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employers`
--

INSERT INTO `employers` (`id`, `company_name`, `contact_name`, `contact_email`, `contact_phone`, `address`) VALUES
(3, 'Tech Company', 'Employer One', 'employer1@company.com', '0987654321', 'Employer Address'),
(4, 'Biz Corp', 'Employer Two', 'employer2@company.com', '1987654321', 'Employer Address 2'),
(5, 'InnoTech', 'Employer Three', 'employer3@company.com', '2987654321', 'Employer Address 3');

-- --------------------------------------------------------

--
-- Table structure for table `jobs`
--

CREATE TABLE `jobs` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `location` varchar(100) DEFAULT NULL,
  `requirements` text DEFAULT NULL,
  `employer_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jobs`
--

INSERT INTO `jobs` (`id`, `title`, `description`, `location`, `requirements`, `employer_id`, `created_at`) VALUES
(1, 'Software Engineer', 'Develop and maintain software applications.', 'Colombo', 'Bachelor\'s degree in Computer Science', 3, '2024-08-07 19:59:40'),
(2, 'Data Analyst', 'Analyze and interpret complex data sets.', 'Colombo', 'Bachelor\'s degree in Data Science', 4, '2024-08-07 19:59:40'),
(3, 'System Administrator', 'Manage and maintain IT systems.', 'Colombo', 'Bachelor\'s degree in IT or related field', 5, '2024-08-07 20:00:54'),
(4, 'Network Engineer', 'Design and implement network solutions.', 'Colombo', 'Bachelor\'s degree in Network Engineering', 5, '2024-08-07 20:00:54');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `address` text DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `major` varchar(100) DEFAULT NULL,
  `graduation_year` year(4) DEFAULT NULL,
  `resume_path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `name`, `email`, `phone`, `address`, `username`, `password`, `major`, `graduation_year`, `resume_path`) VALUES
(5, 'Student One', 'student1@university.com', '1122334455', 'Student Address', 'student1', 'studentpass1', 'Computer Science', '2024', '/path/to/resume1.pdf'),
(6, 'Student Two', 'student2@university.com', '2122334455', 'Student Address 2', 'student2', 'studentpass2', 'Information Technology', '2023', '/path/to/resume2.pdf'),
(7, 'Student Three', 'student3@university.com', '3122334455', 'Student Address 3', 'student3', 'studentpass3', 'Software Engineering', '2025', '/path/to/resume3.pdf'),
(8, 'Student Four', 'student4@university.com', '4122334455', 'Student Address 4', 'student4', 'studentpass4', 'Network Security', '2022', '/path/to/resume4.pdf'),
(9, 'Student Five', 'student5@university.com', '5122334455', 'Student Address 5', 'student5', 'studentpass5', 'Data Science', '2024', '/path/to/resume5.pdf'),
(10, 'kjp', 'jp@gmail.com', '22222', NULL, NULL, NULL, NULL, NULL, NULL),
(11, 'jp', 'jp@g', '1234567', NULL, NULL, NULL, NULL, NULL, NULL),
(12, 'tjk', 'jk@gmail.com', '888888', NULL, NULL, NULL, NULL, NULL, NULL),
(13, 'estrdfyhj', 'fgjh@g', '1234567', NULL, NULL, NULL, NULL, NULL, NULL),
(14, 'jkajan', 'kajan@gmail.com', '2323344', NULL, NULL, NULL, NULL, NULL, NULL),
(15, 'kyuvan', 'yuvan@gmail.com', '3333333', NULL, NULL, NULL, NULL, NULL, NULL),
(16, 'h', 'h@gmail.com', '111111', NULL, NULL, NULL, NULL, NULL, NULL),
(17, 'jj', 'j@gmail.com', '2222', NULL, NULL, NULL, NULL, NULL, NULL),
(35, 'faiha', 'faiha@gmail.com', '88888888', NULL, NULL, NULL, NULL, NULL, NULL),
(36, 'kiruni', 'kiru@gmail.com', '8888888888', NULL, NULL, NULL, NULL, NULL, NULL),
(38, 'dd', 'ff@gmail.com', 's', NULL, NULL, NULL, NULL, NULL, NULL),
(39, 'v', 'v@gmail.com', 'v', NULL, NULL, NULL, NULL, NULL, NULL),
(41, 'c', 'c@gmail.com', 'c', NULL, NULL, NULL, NULL, NULL, NULL),
(42, 'veeroda lakshani', 'veeroda@gmail.com', '78587575', NULL, NULL, NULL, NULL, NULL, NULL),
(43, 'dd', 'bb@gmail.com', '33', NULL, NULL, NULL, NULL, NULL, NULL),
(44, 'veeroda jayawardana', 'veee@gmail.com', '12345678', NULL, NULL, NULL, NULL, NULL, NULL),
(45, 'jjjj', 'jjjj@gmail.com', '223345', NULL, NULL, NULL, NULL, NULL, NULL),
(46, 'f', 'f@gmail.com', '111111', NULL, NULL, NULL, NULL, NULL, NULL),
(48, 'ggg', 'n@gmail.com', '33333', NULL, NULL, NULL, NULL, NULL, NULL),
(50, 'ee', 'k@gmail.com', 'dd', NULL, NULL, NULL, NULL, NULL, NULL),
(51, 'yyyy', 'w@gmail.com', '123456788888', NULL, NULL, NULL, NULL, NULL, NULL),
(52, 'jjj', 'g@gmail.com', '1234466666', NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `full_name` varchar(100) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `address` text DEFAULT NULL,
  `role` enum('student','employer','admin') NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `email`, `full_name`, `phone_number`, `address`, `role`, `created_at`) VALUES
(1, 'admin1', 'adminpass1', 'admin1@jobportal.com', 'Admin One', '1234567890', 'Admin Address', 'admin', '2024-08-07 19:58:56'),
(2, 'admin2', 'adminpass2', 'admin2@jobportal.com', 'Admin Two', '2234567890', 'Admin Address 2', 'admin', '2024-08-07 19:58:56'),
(3, 'employer1', 'employerpass1', 'employer1@company.com', 'Employer One', '0987654321', 'Employer Address', 'employer', '2024-08-07 19:58:56'),
(4, 'employer2', 'employerpass2', 'employer2@company.com', 'Employer Two', '1987654321', 'Employer Address 2', 'employer', '2024-08-07 19:58:56'),
(5, 'student1', 'studentpass1', 'student1@university.com', 'Student One', '1122334455', 'Student Address', 'student', '2024-08-07 19:58:56'),
(6, 'student2', 'studentpass2', 'student2@university.com', 'Student Two', '2122334455', 'Student Address 2', 'student', '2024-08-07 19:58:56'),
(7, 'admin3', 'adminpass3', 'admin3@jobportal.com', 'Admin Three', '3234567890', 'Admin Address 3', 'admin', '2024-08-07 20:00:16'),
(8, 'employer3', 'employerpass3', 'employer3@company.com', 'Employer Three', '2987654321', 'Employer Address 3', 'employer', '2024-08-07 20:00:16'),
(9, 'student3', 'studentpass3', 'student3@university.com', 'Student Three', '3122334455', 'Student Address 3', 'student', '2024-08-07 20:00:16'),
(10, 'student4', 'studentpass4', 'student4@university.com', 'Student Four', '4122334455', 'Student Address 4', 'student', '2024-08-07 20:00:16'),
(11, 'student5', 'studentpass5', 'student5@university.com', 'Student Five', '5122334455', 'Student Address 5', 'student', '2024-08-07 20:00:16');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `applications`
--
ALTER TABLE `applications`
  ADD PRIMARY KEY (`id`),
  ADD KEY `job_id` (`job_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `employers`
--
ALTER TABLE `employers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jobs`
--
ALTER TABLE `jobs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employer_id` (`employer_id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `applications`
--
ALTER TABLE `applications`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `employers`
--
ALTER TABLE `employers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `jobs`
--
ALTER TABLE `jobs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `applications`
--
ALTER TABLE `applications`
  ADD CONSTRAINT `applications_ibfk_1` FOREIGN KEY (`job_id`) REFERENCES `jobs` (`id`),
  ADD CONSTRAINT `applications_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`);

--
-- Constraints for table `employers`
--
ALTER TABLE `employers`
  ADD CONSTRAINT `employers_ibfk_1` FOREIGN KEY (`id`) REFERENCES `users` (`id`);

--
-- Constraints for table `jobs`
--
ALTER TABLE `jobs`
  ADD CONSTRAINT `jobs_ibfk_1` FOREIGN KEY (`employer_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
