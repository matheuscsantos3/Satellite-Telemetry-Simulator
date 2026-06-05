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
print(f"Average radiation: {sum(radiations) / len(radiations):.2f}")

# Min and max values
print(f"Max temperature: {max(temperatures):.2f}")
print(f"Min temperature: {min(temperatures):.2f}")

print(f"Max radiation: {max(radiations):.2f}")
print(f"Min radiation: {min(radiations):.2f}")

# Median values
print(f"Median temperature: {median(temperatures):.2f}")
print(f"Median radiation: {median(radiations):.2f}")

# Standard deviation
print(f"Temperature deviation: {stdev(temperatures):.2f}")
print(f"Radiation deviation: {stdev(radiations):.2f}")

# Temperature chart
plt.plot(temperatures, label="Temperature")

# Radiation chart
plt.plot(radiations, label="Radiation")

# Chart settings
plt.title("Telemetry Data")
plt.xlabel("Packet")
plt.ylabel("Value")

plt.legend()

# Save chart
plt.savefig("telemetry_chart.png")

plt.show()