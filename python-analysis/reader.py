import re
import matplotlib.pyplot as plt
from statistics import median, stdev

# Telemetry data storage
temperatures = []
radiations = []

# Read telemetry file
with open("../java-simulator/telemetry.csv", "r") as file:

    for line in file:

        temp_match = re.search(r"temperature=([\d.]+)", line)
        rad_match = re.search(r"radiation=([\d.]+)", line)

        if temp_match and rad_match:

            temperatures.append(float(temp_match.group(1)))
            radiations.append(float(rad_match.group(1)))

# Basic statistics
print("Packets:", len(temperatures))

print(f"Average temperature: {sum(temperatures) / len(temperatures):.2f}")
print("Average radiation:", sum(radiations) / len(radiations))

# Min and max values
print("Max temperature:", max(temperatures))
print("Min temperature:", min(temperatures))

print("Max radiation:", max(radiations))
print("Min radiation:", min(radiations))

# Median values
print("Median temperature:", median(temperatures))
print("Median radiation:", median(radiations))

# Standard deviation
print("Temperature deviation:", stdev(temperatures))
print("Radiation deviation:", stdev(radiations))

# Temperature chart
plt.plot(temperatures, label="Temperature")

# Radiation chart
plt.plot(radiations, label="Radiation")

# Chart settings
plt.title("Telemetry Data")
plt.xlabel("Packet")
plt.ylabel("Value")

plt.legend()

plt.show()