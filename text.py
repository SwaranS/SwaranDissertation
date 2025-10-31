def solution(A):
	"""
	Given array A of maximum allowed heights, return array B of assigned
	heights (positive integers, all distinct) such that 1 <= B[i] <= A[i]
	and the total sum is maximized.

	Greedy approach:
	- Sort indices by A[i] in descending order.
	- Iterate and for each A[i] take the largest possible height not greater
	  than A[i] and strictly less than the previously assigned height (to
	  preserve uniqueness and maximize sum). Keep heights > 0.
	"""
	if A is None:
		return []
	N = len(A)
	if N == 0:
		return []

	# Pair values with original indices and sort descending by max height
	pairs = sorted([(val, idx) for idx, val in enumerate(A)], reverse=True)

	B = [0] * N
	prev = 10**18  # previous assigned height upper bound

	for val, idx in pairs:
		# choose the largest possible: min(val, prev-1)
		choose = min(val, prev - 1)
		if choose <= 0:
			# According to the problem, it's always possible to assign, so
			# this should not happen for valid inputs. But handle gracefully.
			choose = 1
		B[idx] = choose
		prev = choose

	return B


if __name__ == "__main__":
	# Basic tests
	tests = [
		# (A, expected sum or properties)
		([5, 5, 5], 5 + 4 + 3),
		([1, 2, 3], 3 + 2 + 1),
		([100], 100),
		([], 0),
	]

	# Run checks
	for A, expected_sum in tests:
		B = solution(A)
		# Basic validations
		assert len(B) == len(A)
		assert all(1 <= b <= a for b, a in zip(B, A))
		assert len(set(B)) == len(B) if len(B) > 0 else True
		if expected_sum is not None:
			s = sum(B)
			print(f"A={A} -> B={B}, sum={s}, expected={expected_sum}")
			assert s == expected_sum
		else:
			print(f"A={A} -> B={B}, sum={sum(B)}")

	print("Basic sky tests passed.")

